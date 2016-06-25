package com.joker.wms.webapp;

import net.sourceforge.jwebunit.html.Row;
import net.sourceforge.jwebunit.html.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class GeoWebTest {

    private ResourceBundle messages;

    @Before
    public void setUp() {
        setScriptingEnabled(false);
        getTestContext().setBaseUrl("http://" + System.getProperty("cargo.host") + ":" + System.getProperty("cargo.port"));
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
    }

    @Before
    public void addGeo() {
        beginAt("/editGeo");
        assertTitleKeyMatches("geoDetail.title");
        clickButton("save");
        assertTitleKeyMatches("geoList.title");
        assertKeyPresent("geo.added");
    }

    @Test
    public void listGeoes() {
        beginAt("/geoes");
        assertTitleKeyMatches("geoList.title");

        // check that table is present
        assertTablePresent("geoList");
    }

    @Test
    public void editGeo() {
        beginAt("/editGeo?geoId=" + getInsertedId());
        clickButton("save");
        assertTitleKeyMatches("geoDetail.title");
    }

    @Test
    public void saveGeo() {
        beginAt("/editGeo?id=" + getInsertedId());
        assertTitleKeyMatches("geoDetail.title");

        // update some of the required fields
        clickButton("save");
        assertTitleKeyMatches("geoDetail.title");
        assertKeyPresent("geo.updated");
    }

    @After
    public void removeGeo() {
        beginAt("/editGeo?id=" + getInsertedId());
        clickButton("delete");
        assertTitleKeyMatches("geoList.title");
        assertKeyPresent("geo.deleted");
    }

    /**
     * Convenience method to get the id of the inserted record
     *
     * @return last id in the table
     */
    protected String getInsertedId() {
        beginAt("/geoes");
        assertTablePresent("geoList");
        Table table = getTable("geoList");
        // Find link in last row, skip header row
        for (int i = 1; i < table.getRows().size(); i++) {
            Row row = table.getRows().get(i);
            if (i == table.getRowCount() - 1) {
                return row.getCells().get(0).getValue();
            }
        }
        return "";
    }

    private void assertTitleKeyMatches(String title) {
        assertTitleEquals(messages.getString(title) + " | " + messages.getString("webapp.name"));
    }
}
