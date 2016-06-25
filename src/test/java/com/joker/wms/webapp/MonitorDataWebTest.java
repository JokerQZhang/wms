package com.joker.wms.webapp;

import net.sourceforge.jwebunit.html.Row;
import net.sourceforge.jwebunit.html.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class MonitorDataWebTest {

    private ResourceBundle messages;

    @Before
    public void setUp() {
        setScriptingEnabled(false);
        getTestContext().setBaseUrl("http://" + System.getProperty("cargo.host") + ":" + System.getProperty("cargo.port"));
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
    }

    @Before
    public void addMonitorData() {
        beginAt("/editMonitorData");
        assertTitleKeyMatches("monitorDataDetail.title");
        clickButton("save");
        assertTitleKeyMatches("monitorDataList.title");
        assertKeyPresent("monitorData.added");
    }

    @Test
    public void listMonitorDatas() {
        beginAt("/monitorDatas");
        assertTitleKeyMatches("monitorDataList.title");

        // check that table is present
        assertTablePresent("monitorDataList");
    }

    @Test
    public void editMonitorData() {
        beginAt("/editMonitorData?monitorId=" + getInsertedId());
        clickButton("save");
        assertTitleKeyMatches("monitorDataDetail.title");
    }

    @Test
    public void saveMonitorData() {
        beginAt("/editMonitorData?id=" + getInsertedId());
        assertTitleKeyMatches("monitorDataDetail.title");

        // update some of the required fields
        clickButton("save");
        assertTitleKeyMatches("monitorDataDetail.title");
        assertKeyPresent("monitorData.updated");
    }

    @After
    public void removeMonitorData() {
        beginAt("/editMonitorData?id=" + getInsertedId());
        clickButton("delete");
        assertTitleKeyMatches("monitorDataList.title");
        assertKeyPresent("monitorData.deleted");
    }

    /**
     * Convenience method to get the id of the inserted record
     *
     * @return last id in the table
     */
    protected String getInsertedId() {
        beginAt("/monitorDatas");
        assertTablePresent("monitorDataList");
        Table table = getTable("monitorDataList");
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
