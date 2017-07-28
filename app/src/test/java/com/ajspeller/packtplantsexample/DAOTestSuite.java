package com.ajspeller.packtplantsexample;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * Created by ny2va on 7/28/2017.
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BDDTestPlantDAO.class,
        TestNetworkDAO.class
})
public class DAOTestSuite {
}
