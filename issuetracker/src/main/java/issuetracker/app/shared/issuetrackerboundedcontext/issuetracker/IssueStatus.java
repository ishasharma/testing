package issuetracker.app.shared.issuetrackerboundedcontext.issuetracker;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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

@Table(name = "ast_IssueStatus_M")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "IssueStatus", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "IssueStatus.DefaultFinders", query = "select e from IssueStatus e where e.systemInfo.activeStatus=1 and e.issueStageCode LIKE :issueStageCode"), @javax.persistence.NamedQuery(name = "IssueStatus.findByIssueStageCode", query = "select e from IssueStatus e where e.systemInfo.activeStatus=1 and e.issueStageCode=:issueStageCode"), @javax.persistence.NamedQuery(name = "IssueStatus.findById", query = "select e from IssueStatus e where e.systemInfo.activeStatus=1 and e.issueStatusCode =:issueStatusCode") })
public class IssueStatus implements Serializable, CommonEntityInterface, Comparator<IssueStatus> {

    @Column(name = "issueStatusId")
    @JsonProperty("issueStatusId")
    @NotNull
    @Size(min = 0, max = 64)
    private String issueStatusId;

    @Column(name = "issueStatusName")
    @JsonProperty("issueStatusName")
    @NotNull
    @Size(min = 0, max = 256)
    private String issueStatusName;

    @Column(name = "issueStatusDesc")
    @JsonProperty("issueStatusDesc")
    @Size(min = 0, max = 1024)
    private String issueStatusDesc;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "issueStatusCode")
    @JsonProperty("issueStatusCode")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String issueStatusCode;

    @Column(name = "issueStageCode")
    @JsonProperty("issueStageCode")
    private String issueStageCode;

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

    public String getIssueStatusId() {
        return issueStatusId;
    }

    public void setIssueStatusId(String _issueStatusId) {
        if (_issueStatusId != null) {
            this.issueStatusId = _issueStatusId;
        }
    }

    public String getIssueStatusName() {
        return issueStatusName;
    }

    public void setIssueStatusName(String _issueStatusName) {
        if (_issueStatusName != null) {
            this.issueStatusName = _issueStatusName;
        }
    }

    public String getIssueStatusDesc() {
        return issueStatusDesc;
    }

    public void setIssueStatusDesc(String _issueStatusDesc) {
        this.issueStatusDesc = _issueStatusDesc;
    }

    public String getPrimaryKey() {
        return issueStatusCode;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return issueStatusCode;
    }

    public String getIssueStatusCode() {
        return issueStatusCode;
    }

    public void setIssueStatusCode(String _issueStatusCode) {
        this.issueStatusCode = _issueStatusCode;
    }

    public String getIssueStageCode() {
        return issueStageCode;
    }

    public void setIssueStageCode(String _issueStageCode) {
        this.issueStageCode = _issueStageCode;
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

    @Override
    public int compare(IssueStatus object1, IssueStatus object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((issueStatusId == null ? " " : issueStatusId) + ",");
        sb.append((issueStatusName == null ? " " : issueStatusName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (issueStatusCode == null) {
            return super.hashCode();
        } else {
            return issueStatusCode.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus other = (issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus) obj;
            if (issueStatusCode == null) {
                return false;
            } else if (!issueStatusCode.equals(other.issueStatusCode)) {
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
}
