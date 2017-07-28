package com.ajspeller.packtplantsexample;

import com.ajspeller.packtplantsexample.dao.NetworkDAO;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

/**
 * Created by ny2va on 7/27/2017.
 */

public class TestNetworkDAO {

    private NetworkDAO networkDAO;

    @Before
    public void setup() {
        networkDAO = new NetworkDAO();
    }

    @Test
    public void fetchShouldSucceedWhenGivenValidURI() throws IOException {
        String result =
                networkDAO.fetch
                        ("http://plantplaces.com/perl/mobile/viewplantsjson.pl?Combined_Name=dkkaj");

        // expected, actual
        assertEquals("{\"plants\":[]}-1", result);

    }
}
