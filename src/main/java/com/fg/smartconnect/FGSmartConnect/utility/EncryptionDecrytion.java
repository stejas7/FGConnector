package com.fg.smartconnect.FGSmartConnect.utility;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.encryptionsdk.AwsCrypto;
import com.amazonaws.encryptionsdk.CryptoResult;
import com.amazonaws.encryptionsdk.kms.KmsMasterKey;
import com.amazonaws.encryptionsdk.kms.KmsMasterKeyProvider;
import com.fg.smartconnect.FGSmartConnect.config.FGSmartConnectConfig;

// TODO: Auto-generated Javadoc
/**
 * The Class EncryptionDecrytion.
 */
@Component
public class EncryptionDecrytion
{

	/** The fg smart connect config. */
	@Autowired
	FGSmartConnectConfig fgSmartConnectConfig;

	/** The Constant KMS_DATA_TYPE. */
	private static final String KMS_DATA_TYPE = "dataType";

	/** The Constant KMS_CLITNT_VALUE. */
	private static final String KMS_CLITNT_VALUE = "yojaka";

	/** The Constant KMS_Client. */
	private static final String KMS_Client = "client";

	private AwsCrypto awsCrypto = new AwsCrypto();

	/**
	 * Decrypt yojaka encrypted data.
	 *
	 * @param value the value
	 * @param encryptionInfoContext the encryption info context
	 * @return the byte[]
	 */
	public String decryptYojakaEncryptedData(String value, String encryptionInfoContext)
	{
		KmsMasterKeyProvider kmsMasterKeyProvider = KmsMasterKeyProvider.builder().withCredentials(new AWSStaticCredentialsProvider(
				new BasicAWSCredentials(fgSmartConnectConfig.getAwsKmsAccessKey(), fgSmartConnectConfig.getAwsKmsSecretAccessKey())))
				.withKeysForEncryption(fgSmartConnectConfig.getAwsKMSKey())
				.withDefaultRegion(fgSmartConnectConfig.getAwsKMSKeyRegion()).build();

		CryptoResult<byte[], KmsMasterKey> decryptedDataEnvelope = awsCrypto.decryptData(kmsMasterKeyProvider, Base64.getDecoder().decode(value));

		Map<String, String> encryptionContextMap = decryptedDataEnvelope.getEncryptionContext();
		if (!encryptionContextMap.containsKey(KMS_Client)
				|| !encryptionContextMap.get(KMS_Client).equals(KMS_CLITNT_VALUE))
		{
			throw new IllegalStateException();
		}
		if (!encryptionContextMap.containsKey(KMS_DATA_TYPE)
				|| !encryptionContextMap.get(KMS_DATA_TYPE).equals(encryptionInfoContext))
		{
			throw new IllegalStateException();
		}

		return new String(decryptedDataEnvelope.getResult(), StandardCharsets.UTF_8);
	}

}
