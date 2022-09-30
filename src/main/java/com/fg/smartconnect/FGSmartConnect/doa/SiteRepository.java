package com.fg.smartconnect.FGSmartConnect.doa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.fg.smartconnect.FGSmartConnect.model.SiteMst;

/**
 * The Interface SiteRepository.
 * 
 * @author Tejas Shah
 */
@Repository
public interface SiteRepository extends JpaRepository<SiteMst, Long>
{

}
