package issuetracker.app.shared.issuetrackerboundedcontext.projectmanager;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.Table;
import org.eclipse.persistence.annotations.Cache;
import org.eclipse.persistence.annotations.CacheType;
import org.eclipse.persistence.config.CacheIsolationType;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.persistence.Column;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import issuetracker.app.shared.EntityAudit;
import javax.persistence.Embedded;
import issuetracker.app.shared.SystemInfo;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_FeatureUserMapping_TP")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "root", versionNumber = "3", comments = "FeatureUserMapping", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "FeatureUserMapping.findByProjectId", query = "select e from FeatureUserMapping e where e.systemInfo.activeStatus=1 and e.projectId=:projectId"), @javax.persistence.NamedQuery(name = "FeatureUserMapping.findByModuleId", query = "select e from FeatureUserMapping e where e.systemInfo.activeStatus=1 and e.moduleId=:moduleId"), @javax.persistence.NamedQuery(name = "FeatureUserMapping.findByFeatureId", query = "select e from FeatureUserMapping e where e.systemInfo.activeStatus=1 and e.projectFeature.featureId=:featureId"), @javax.persistence.NamedQuery(name = "FeatureUserMapping.findByContactId", query = "select e from FeatureUserMapping e where e.systemInfo.activeStatus=1 and e.contactId=:contactId"), @javax.persistence.NamedQuery(name = "FeatureUserMapping.findById", query = "select e from FeatureUserMapping e where e.systemInfo.activeStatus=1 and e.feaUserId =:feaUserId") })
public class FeatureUserMapping implements Serializable, CommonEntityInterface, Comparator<FeatureUserMapping> {

    @Column(name = "isAdmin")
    @JsonProperty("isAdmin")
    private Boolean isAdmin = false;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "feaUserId")
    @JsonProperty("feaUserId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String feaUserId;

    @Column(name = "projectId")
    @JsonProperty("projectId")
    private String projectId;

    @Column(name = "moduleId")
    @JsonProperty("moduleId")
    private String moduleId;

    @Column(name = "contactId")
    @JsonProperty("contactId")
    private String contactId;

    @OneToOne(cascade = CascadeType.REFRESH, fetch = FetchType.LAZY)
    @JoinColumn(name = "featureId", referencedColumnName = "featureId")
    private ProjectFeature projectFeature;

    @Transient
    @JsonIgnore
    private EntityValidatorHelper<Object> entityValidator;

    @Version
    @Column(name = "versionId")
    @JsonProperty("versionId")
    private int versionId;

    @Embedded
    @JsonIgnore
    private EntityAudit entityAudit = new EntityAudit();

    @Embedded
    private SystemInfo systemInfo = new SystemInfo();

    @Transient
    private String primaryDisplay;

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean _isAdmin) {
        this.isAdmin = _isAdmin;
    }

    public String getPrimaryKey() {
        return feaUserId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return feaUserId;
    }

    public String getFeaUserId() {
        return feaUserId;
    }

    public void setFeaUserId(String _feaUserId) {
        this.feaUserId = _feaUserId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String _projectId) {
        this.projectId = _projectId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String _moduleId) {
        this.moduleId = _moduleId;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String _contactId) {
        this.contactId = _contactId;
    }

    public int getVersionId() {
        return versionId;
    }

    public void setVersionId(int _versionId) {
        this.versionId = _versionId;
    }

    public void setPrimaryDisplay(String _primaryDisplay) {
        this.primaryDisplay = _primaryDisplay;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo _systemInfo) {
        this.systemInfo = _systemInfo;
    }

    public ProjectFeature getProjectFeature() {
        return projectFeature;
    }

    public void setProjectFeature(ProjectFeature _projectFeature) {
        this.projectFeature = _projectFeature;
    }

    @JsonIgnore
    public boolean isHardDelete() {
        if (this.systemInfo == null) {
            this.systemInfo = new SystemInfo();
        }
        if (this.systemInfo.getActiveStatus() == -1) {
            return true;
        } else {
            return false;
        }
    }

    @JsonIgnore
    @Override
    public boolean isValid() throws SpartanConstraintViolationException, SpartanIncorrectDataException {
        boolean isValid = false;
        if (this.entityValidator != null) {
            isValid = this.entityValidator.validateEntity(this);
            this.systemInfo.setEntityValidated(true);
        } else {
            throw new SpartanIncorrectDataException("Entity validator is not set");
        }
        return isValid;
    }

    @Override
    public void setEntityValidator(EntityValidatorHelper<Object> _validateFactory) {
        this.entityValidator = _validateFactory;
    }

    @Override
    public void setEntityAudit(int customerId, String userId, RECORD_TYPE recordType) {
        System.out.println("Setting logged in user info for " + recordType);
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (recordType == RECORD_TYPE.ADD) {
            this.entityAudit.setCreatedBy(userId);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
        setSystemInformation(recordType);
    }

    @Override
    public void setEntityAudit(int customerId, String userId) {
        if (entityAudit == null) {
            entityAudit = new EntityAudit();
        }
        if (getPrimaryKey() == null) {
            this.entityAudit.setCreatedBy(userId);
            this.systemInfo.setActiveStatus(1);
        } else {
            this.entityAudit.setUpdatedBy(userId);
        }
    }

    @JsonIgnore
    public String getLoggedInUserInfo() {
        String auditInfo = "";
        if (this.entityAudit != null) {
            auditInfo = entityAudit.toString();
        }
        return auditInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemInformation(RECORD_TYPE recordType) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        if (recordType == RECORD_TYPE.DELETE) {
            this.systemInfo.setActiveStatus(0);
        } else {
            this.systemInfo.setActiveStatus(1);
        }
    }

    @JsonIgnore
    public void setSystemInformation(Integer activeStatus) {
        this.systemInfo.setActiveStatus(activeStatus);
    }

    @JsonIgnore
    public String getSystemInformation() {
        String systemInfo = "";
        if (this.systemInfo != null) {
            systemInfo = systemInfo.toString();
        }
        return systemInfo;
    }

    @Override
    @JsonIgnore
    public void setSystemTxnCode(Integer transactionAccessCode) {
        if (systemInfo == null) {
            systemInfo = new SystemInfo();
        }
        this.systemInfo.setTxnAccessCode(transactionAccessCode);
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((isAdmin == null ? " " : isAdmin) + ",");
        sb.append((projectId.toString() == null ? " " : projectId.toString()) + ",");
        sb.append((moduleId.toString() == null ? " " : moduleId.toString()) + ",");
        sb.append((projectFeature.getPrimaryDisplay().toString() == null ? " " : projectFeature.getPrimaryDisplay().toString()) + ",");
        sb.append((contactId.toString() == null ? " " : contactId.toString()));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (feaUserId == null) {
            return super.hashCode();
        } else {
            return feaUserId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping other = (issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping) obj;
            if (feaUserId == null) {
                return false;
            } else if (!feaUserId.equals(other.feaUserId)) {
                return false;
            }
        } catch (java.lang.Exception ignore) {
            return false;
        }
        return true;
    }

    @JsonIgnore
    public boolean isEntityValidated() {
        return this.systemInfo.isEntityValidated();
    }

    @Transient
    @JsonIgnore
    private String fieldName;

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String _fieldName) {
        this.fieldName = _fieldName;
    }

    @Override
    public int compare(FeatureUserMapping object1, FeatureUserMapping object2) {
        switch(((fieldName))) {
            case "feaUserId":
                return (object1.getFeaUserId().compareTo(object2.getFeaUserId()) == 0) ? 0 : ((object1.getFeaUserId().compareTo(object2.getFeaUserId()) > 0) ? 1 : -1);
        }
        return 0;
    }
}
