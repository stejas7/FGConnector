package com.fg.smartconnect.FGSmartConnect.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fg.smartconnect.FGSmartConnect.model.CutsomerMasterData;

/**
 * The Interface CustomerRepositary.
 *
 * @author Tejas Shah
 */
@Repository
public interface CustomerRepositary extends JpaRepository<CutsomerMasterData, Long>
{

}
