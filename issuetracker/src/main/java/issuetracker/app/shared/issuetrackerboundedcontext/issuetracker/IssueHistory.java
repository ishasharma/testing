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
import java.sql.Date;
import javax.persistence.Column;
import com.athena.config.jsonHandler.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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

@Table(name = "ast_IssueHistory_M")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "IssueHistory", complexity = Complexity.LOW)
@NamedQueries({ @javax.persistence.NamedQuery(name = "IssueHistory.DefaultFinders", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueHistId LIKE :issueHistId"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueId", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueId=:issueId"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueCategoryCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueCategoryCode=:issueCategoryCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByFeatureCategoryCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.featureCategoryCode=:featureCategoryCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueSeverityCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueSeverityCode=:issueSeverityCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssuePriorityCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issuePriorityCode=:issuePriorityCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueFlagCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueFlagCode=:issueFlagCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueStageCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueStageCode=:issueStageCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueStatusCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueStatusCode=:issueStatusCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByIssueActivityCode", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueActivityCode=:issueActivityCode"), @javax.persistence.NamedQuery(name = "IssueHistory.findByContactId", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.contactId=:contactId"), @javax.persistence.NamedQuery(name = "IssueHistory.findById", query = "select e from IssueHistory e where e.systemInfo.activeStatus=1 and e.issueHistId =:issueHistId") })
public class IssueHistory implements Serializable, CommonEntityInterface, Comparator<IssueHistory> {

    @Column(name = "effortEstimate")
    @JsonProperty("effortEstimate")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date effortEstimate;

    @Column(name = "lastUpdated")
    @JsonProperty("lastUpdated")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date lastUpdated;

    @Column(name = "issueDate")
    @JsonProperty("issueDate")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date issueDate;

    @Column(name = "startTime")
    @JsonProperty("startTime")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date startTime;

    @Column(name = "endTime")
    @JsonProperty("endTime")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date endTime;

    @Column(name = "comments")
    @JsonProperty("comments")
    @Size(min = 0, max = 1024)
    private String comments;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "issueHistId")
    @JsonProperty("issueHistId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String issueHistId;

    @Column(name = "issueId")
    @JsonProperty("issueId")
    private String issueId;

    @Column(name = "issueCategoryCode")
    @JsonProperty("issueCategoryCode")
    private String issueCategoryCode;

    @Column(name = "featureCategoryCode")
    @JsonProperty("featureCategoryCode")
    private String featureCategoryCode;

    @Column(name = "issueSeverityCode")
    @JsonProperty("issueSeverityCode")
    private String issueSeverityCode;

    @Column(name = "issuePriorityCode")
    @JsonProperty("issuePriorityCode")
    private String issuePriorityCode;

    @Column(name = "issueFlagCode")
    @JsonProperty("issueFlagCode")
    private String issueFlagCode;

    @Column(name = "issueStageCode")
    @JsonProperty("issueStageCode")
    private String issueStageCode;

    @Column(name = "issueStatusCode")
    @JsonProperty("issueStatusCode")
    private String issueStatusCode;

    @Column(name = "issueActivityCode")
    @JsonProperty("issueActivityCode")
    private String issueActivityCode;

    @Column(name = "contactId")
    @JsonProperty("contactId")
    private String contactId;

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

    public Date getEffortEstimate() {
        return effortEstimate;
    }

    public void setEffortEstimate(Date _effortEstimate) {
        this.effortEstimate = _effortEstimate;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date _lastUpdated) {
        this.lastUpdated = _lastUpdated;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Date _issueDate) {
        this.issueDate = _issueDate;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date _startTime) {
        this.startTime = _startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date _endTime) {
        this.endTime = _endTime;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String _comments) {
        this.comments = _comments;
    }

    public String getPrimaryKey() {
        return issueHistId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return issueHistId;
    }

    public String getIssueHistId() {
        return issueHistId;
    }

    public void setIssueHistId(String _issueHistId) {
        this.issueHistId = _issueHistId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String _issueId) {
        this.issueId = _issueId;
    }

    public String getIssueCategoryCode() {
        return issueCategoryCode;
    }

    public void setIssueCategoryCode(String _issueCategoryCode) {
        this.issueCategoryCode = _issueCategoryCode;
    }

    public String getFeatureCategoryCode() {
        return featureCategoryCode;
    }

    public void setFeatureCategoryCode(String _featureCategoryCode) {
        this.featureCategoryCode = _featureCategoryCode;
    }

    public String getIssueSeverityCode() {
        return issueSeverityCode;
    }

    public void setIssueSeverityCode(String _issueSeverityCode) {
        this.issueSeverityCode = _issueSeverityCode;
    }

    public String getIssuePriorityCode() {
        return issuePriorityCode;
    }

    public void setIssuePriorityCode(String _issuePriorityCode) {
        this.issuePriorityCode = _issuePriorityCode;
    }

    public String getIssueFlagCode() {
        return issueFlagCode;
    }

    public void setIssueFlagCode(String _issueFlagCode) {
        this.issueFlagCode = _issueFlagCode;
    }

    public String getIssueStageCode() {
        return issueStageCode;
    }

    public void setIssueStageCode(String _issueStageCode) {
        this.issueStageCode = _issueStageCode;
    }

    public String getIssueStatusCode() {
        return issueStatusCode;
    }

    public void setIssueStatusCode(String _issueStatusCode) {
        this.issueStatusCode = _issueStatusCode;
    }

    public String getIssueActivityCode() {
        return issueActivityCode;
    }

    public void setIssueActivityCode(String _issueActivityCode) {
        this.issueActivityCode = _issueActivityCode;
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
    public int compare(IssueHistory object1, IssueHistory object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((issueCategoryCode.toString() == null ? " " : issueCategoryCode.toString()) + ",");
        sb.append((featureCategoryCode.toString() == null ? " " : featureCategoryCode.toString()) + ",");
        sb.append((issueSeverityCode.toString() == null ? " " : issueSeverityCode.toString()) + ",");
        sb.append((issuePriorityCode.toString() == null ? " " : issuePriorityCode.toString()) + ",");
        sb.append((effortEstimate == null ? " " : effortEstimate) + ",");
        sb.append((issueFlagCode.toString() == null ? " " : issueFlagCode.toString()) + ",");
        sb.append((issueStageCode.toString() == null ? " " : issueStageCode.toString()) + ",");
        sb.append((issueStatusCode.toString() == null ? " " : issueStatusCode.toString()) + ",");
        sb.append((issueActivityCode.toString() == null ? " " : issueActivityCode.toString()) + ",");
        sb.append((lastUpdated == null ? " " : lastUpdated) + ",");
        sb.append((contactId.toString() == null ? " " : contactId.toString()) + ",");
        sb.append((issueDate == null ? " " : issueDate) + ",");
        sb.append((startTime == null ? " " : startTime) + ",");
        sb.append((endTime == null ? " " : endTime) + ",");
        sb.append((comments == null ? " " : comments));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (issueHistId == null) {
            return super.hashCode();
        } else {
            return issueHistId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueHistory other = (issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueHistory) obj;
            if (issueHistId == null) {
                return false;
            } else if (!issueHistId.equals(other.issueHistId)) {
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
