package com.abetterplanner.data;

import static org.assertj.core.api.Assertions.*;
import org.assertj.core.api.SoftAssertions;
import com.abetterplanner.data.CatalogImport;

import org.junit.Test;

import java.io.IOException;

public class CatalogImportTest {

    @Test
    public void getFileExists(){
        // given
        CatalogImport cImport = new CatalogImport();
        // when
        // then
        assertThat(cImport).isNotNull();
    }

    @Test
    public void connectToCalPoly() throws IOException {
        // given
        CatalogImport cImport = new CatalogImport();
        SoftAssertions softly = new SoftAssertions();
        // when
        String website = "http://schedule.cpp.edu";
        //then
        softly.assertThat(cImport.connectToClassSearch(website)).isNotNull();
    }

}
