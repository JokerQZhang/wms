package com.joker.wms.webapp;

import net.sourceforge.jwebunit.html.Row;
import net.sourceforge.jwebunit.html.Table;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ResourceBundle;

import static net.sourceforge.jwebunit.junit.JWebUnit.*;

public class AlarmSetWebTest {

    private ResourceBundle messages;

    @Before
    public void setUp() {
        setScriptingEnabled(false);
        getTestContext().setBaseUrl("http://" + System.getProperty("cargo.host") + ":" + System.getProperty("cargo.port"));
        getTestContext().setResourceBundleName("messages");
        messages = ResourceBundle.getBundle("messages");
    }

    @Before
    public void addAlarmSet() {
        beginAt("/editAlarmSet");
        assertTitleKeyMatches("alarmSetDetail.title");
        clickButton("save");
        assertTitleKeyMatches("alarmSetList.title");
        assertKeyPresent("alarmSet.added");
    }

    @Test
    public void listAlarmSets() {
        beginAt("/alarmSets");
        assertTitleKeyMatches("alarmSetList.title");

        // check that table is present
        assertTablePresent("alarmSetList");
    }

    @Test
    public void editAlarmSet() {
        beginAt("/editAlarmSet?alarmSetId=" + getInsertedId());
        clickButton("save");
        assertTitleKeyMatches("alarmSetDetail.title");
    }

    @Test
    public void saveAlarmSet() {
        beginAt("/editAlarmSet?id=" + getInsertedId());
        assertTitleKeyMatches("alarmSetDetail.title");

        // update some of the required fields
        clickButton("save");
        assertTitleKeyMatches("alarmSetDetail.title");
        assertKeyPresent("alarmSet.updated");
    }

    @After
    public void removeAlarmSet() {
        beginAt("/editAlarmSet?id=" + getInsertedId());
        clickButton("delete");
        assertTitleKeyMatches("alarmSetList.title");
        assertKeyPresent("alarmSet.deleted");
    }

    /**
     * Convenience method to get the id of the inserted record
     *
     * @return last id in the table
     */
    protected String getInsertedId() {
        beginAt("/alarmSets");
        assertTablePresent("alarmSetList");
        Table table = getTable("alarmSetList");
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
