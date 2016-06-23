package com.joker.wms.webapp.action;

import com.opensymphony.xwork2.Preparable;
import com.joker.wms.service.RoleTypeManager;
import com.joker.wms.dao.SearchException;
import com.joker.wms.model.RoleType;
import com.joker.wms.webapp.action.BaseAction;

import java.util.Date;
import java.util.List;

public class RoleTypeAction extends BaseAction implements Preparable {
    private RoleTypeManager roleTypeManager;
    private List roleTypes;
    private RoleType roleType;
    private Long roleTypeId;
    private String query;

    public void setRoleTypeManager(RoleTypeManager roleTypeManager) {
        this.roleTypeManager = roleTypeManager;
    }

    public List getRoleTypes() {
        return roleTypes;
    }

    /**
     * Grab the entity from the database before populating with request parameters
     */
    public void prepare() {
        if (getRequest().getMethod().equalsIgnoreCase("post")) {
            // prevent failures on new
            String roleTypeId = getRequest().getParameter("roleType.roleTypeId");
            if (roleTypeId != null && !roleTypeId.equals("")) {
                roleType = roleTypeManager.get(new Long(roleTypeId));
            }
        }
    }

    public void setQ(String q) {
        this.query = q;
    }

    public String list() {
        try {
            roleTypes = roleTypeManager.search(query, RoleType.class, getPage());
        } catch (SearchException se) {
            addActionError(se.getMessage());
            roleTypes = roleTypeManager.getAll(getPage());
        }
        if(query != null){
        	getRequest().setAttribute("showForm", "showData");
        }
        return SUCCESS;
    }

    public void setRoleTypeId(Long roleTypeId) {
        this.roleTypeId = roleTypeId;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public String delete() {
        roleTypeManager.remove(roleType.getRoleTypeId());
        saveMessage(getText("roleType.deleted"));

        return SUCCESS;
    }

    public String edit() {
        if (roleTypeId != null) {
            roleType = roleTypeManager.get(roleTypeId);
        } else {
            roleType = new RoleType();
        }

        return SUCCESS;
    }

    public String save() throws Exception {
        if (cancel != null) {
            super.setJsonResult("取消保存");
            return "jsonResult";
        }

        if (delete != null) {
            roleTypeManager.remove(roleType.getRoleTypeId());
        	super.setJsonResult("删除成功");
            return "jsonResult";
        }

        boolean isNew = (roleType.getRoleTypeId() == null);
        if(isNew){
        	roleType.setCreatedByUser(getCurrentUser().getId());
        	roleType.setCreatedTime(new Date());
        }else{
        	roleType.setLastUpdatedByUser(getCurrentUser().getId());
        	roleType.setLastUpdatedTime(new Date());
        }
        roleTypeManager.save(roleType);

        String key = (isNew) ? "roleType.added" : "roleType.updated";
        saveMessage(getText(key));

        super.setJsonResult("保存成功");
        return "jsonResult";
    }
}