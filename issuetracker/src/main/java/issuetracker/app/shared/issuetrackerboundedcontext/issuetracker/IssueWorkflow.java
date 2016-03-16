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
import java.sql.Date;
import com.athena.config.jsonHandler.CustomJsonDateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.athena.config.jsonHandler.CustomJsonDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Transient;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.util.List;
import javax.persistence.OneToMany;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Version;
import issuetracker.app.shared.EntityAudit;
import javax.persistence.Embedded;
import issuetracker.app.shared.SystemInfo;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators.PropertyGenerator;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import java.lang.Override;
import javax.persistence.NamedQueries;

@Table(name = "ast_IssueWorkflow_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "IssueWorkflow", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "issueId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "IssueWorkflow.findByCreatorContactId", query = "select e from IssueWorkflow e where e.systemInfo.activeStatus=1 and e.creatorContactId=:creatorContactId"), @javax.persistence.NamedQuery(name = "IssueWorkflow.findByProjectId", query = "select e from IssueWorkflow e where e.systemInfo.activeStatus=1 and e.projectId=:projectId"), @javax.persistence.NamedQuery(name = "IssueWorkflow.findByModuleId", query = "select e from IssueWorkflow e where e.systemInfo.activeStatus=1 and e.moduleId=:moduleId"), @javax.persistence.NamedQuery(name = "IssueWorkflow.findByFeatureId", query = "select e from IssueWorkflow e where e.systemInfo.activeStatus=1 and e.featureId=:featureId"), @javax.persistence.NamedQuery(name = "IssueWorkflow.findById", query = "select e from IssueWorkflow e where e.systemInfo.activeStatus=1 and e.issueId =:issueId") })
public class IssueWorkflow implements Serializable, CommonEntityInterface, Comparator<IssueWorkflow> {

    @Column(name = "issueTitle")
    @JsonProperty("issueTitle")
    @NotNull
    @Size(min = 0, max = 256)
    private String issueTitle;

    @Column(name = "issueDescription")
    @JsonProperty("issueDescription")
    @NotNull
    @Size(min = 0, max = 1024)
    private String issueDescription;

    @Column(name = "stepsToReproduce")
    @JsonProperty("stepsToReproduce")
    @Size(min = 0, max = 1024)
    private String stepsToReproduce;

    @Column(name = "dateCreated")
    @JsonProperty("dateCreated")
    @NotNull
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date dateCreated;

    @Column(name = "browser")
    @JsonProperty("browser")
    @Size(min = 0, max = 256)
    private String browser;

    @Column(name = "OS")
    @JsonProperty("oS")
    @Size(min = 0, max = 256)
    private String oS;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "issueId")
    @JsonProperty("issueId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String issueId;

    @Column(name = "creatorContactId")
    @JsonProperty("creatorContactId")
    private String creatorContactId;

    @Column(name = "projectId")
    @JsonProperty("projectId")
    private String projectId;

    @Column(name = "moduleId")
    @JsonProperty("moduleId")
    private String moduleId;

    @Column(name = "featureId")
    @JsonProperty("featureId")
    private String featureId;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "issueWorkflow")
    private IssueAssignment issueAssignment;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "issueWorkflow")
    private List<AddWatchers> addWatchers;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "issueWorkflow")
    private IssueHeaders issueHeaders;

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

    public String getIssueTitle() {
        return issueTitle;
    }

    public void setIssueTitle(String _issueTitle) {
        if (_issueTitle != null) {
            this.issueTitle = _issueTitle;
        }
    }

    public String getIssueDescription() {
        return issueDescription;
    }

    public void setIssueDescription(String _issueDescription) {
        if (_issueDescription != null) {
            this.issueDescription = _issueDescription;
        }
    }

    public String getStepsToReproduce() {
        return stepsToReproduce;
    }

    public void setStepsToReproduce(String _stepsToReproduce) {
        this.stepsToReproduce = _stepsToReproduce;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date _dateCreated) {
        if (_dateCreated != null) {
            this.dateCreated = _dateCreated;
        }
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String _browser) {
        this.browser = _browser;
    }

    public String getoS() {
        return oS;
    }

    public void setoS(String _oS) {
        this.oS = _oS;
    }

    public String getPrimaryKey() {
        return issueId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return issueId;
    }

    public String getIssueId() {
        return issueId;
    }

    public void setIssueId(String _issueId) {
        this.issueId = _issueId;
    }

    public String getCreatorContactId() {
        return creatorContactId;
    }

    public void setCreatorContactId(String _creatorContactId) {
        this.creatorContactId = _creatorContactId;
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

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String _featureId) {
        this.featureId = _featureId;
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

    public IssueAssignment getIssueAssignment() {
        return issueAssignment;
    }

    public void setIssueAssignment(IssueAssignment _issueAssignment) {
        if (_issueAssignment.getIssueWorkflow() == null) {
            _issueAssignment.setIssueWorkflow(this);
        }
        this.issueAssignment = _issueAssignment;
    }

    public IssueWorkflow addAddWatchers(AddWatchers _addWatchers) {
        if (this.addWatchers == null) {
            this.addWatchers = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers>();
        }
        if (_addWatchers != null) {
            _addWatchers.setIssueWorkflow(this);
            this.addWatchers.add(_addWatchers);
        }
        return this;
    }

    public IssueWorkflow removeAddWatchers(AddWatchers _addWatchers) {
        if (this.addWatchers != null) {
            this.addWatchers.remove(_addWatchers);
        }
        return this;
    }

    public IssueWorkflow addAllAddWatchers(List<AddWatchers> _addWatchers) {
        if (this.addWatchers == null) {
            this.addWatchers = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers>();
        }
        if (_addWatchers != null) {
            for (int i = 0; i < _addWatchers.size(); i++) {
                _addWatchers.get(i).setIssueWorkflow(this);
            }
            this.addWatchers.addAll(_addWatchers);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfAddWatchers() {
        if (this.addWatchers != null) {
            return this.addWatchers.size();
        }
        return 0;
    }

    public List<AddWatchers> getAddWatchers() {
        return addWatchers;
    }

    public void setAddWatchers(List<AddWatchers> _addWatchers) {
        for (int i = 0; i < _addWatchers.size(); i++) {
            if (_addWatchers.get(i).getIssueWorkflow() == null) {
                _addWatchers.get(i).setIssueWorkflow(this);
            }
        }
        this.addWatchers = _addWatchers;
    }

    @JsonIgnore
    public List<AddWatchers> getDeletedAddWatchersList() {
        List<AddWatchers> addwatchersToRemove = new java.util.ArrayList<AddWatchers>();
        for (AddWatchers _addwatchers : addWatchers) {
            if (_addwatchers.isHardDelete()) {
                addwatchersToRemove.add(_addwatchers);
            }
        }
        addWatchers.removeAll(addwatchersToRemove);
        return addwatchersToRemove;
    }

    public IssueHeaders getIssueHeaders() {
        return issueHeaders;
    }

    public void setIssueHeaders(IssueHeaders _issueHeaders) {
        if (_issueHeaders.getIssueWorkflow() == null) {
            _issueHeaders.setIssueWorkflow(this);
        }
        this.issueHeaders = _issueHeaders;
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
        setValidatoraddWatchers(_validateFactory);
    }

    private void setValidatoraddWatchers(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < addWatchers.size(); i++) {
            addWatchers.get(i).setEntityValidator(_validateFactory);
        }
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
        if (this.issueAssignment != null) {
            issueAssignment.setEntityAudit(customerId, userId, recordType);
            issueAssignment.setSystemInformation(recordType);
        }
        if (this.addWatchers == null) {
            this.addWatchers = new java.util.ArrayList<AddWatchers>();
        }
        for (AddWatchers _addWatchers : addWatchers) {
            _addWatchers.setEntityAudit(customerId, userId, recordType);
            _addWatchers.setSystemInformation(recordType);
        }
        if (this.issueHeaders != null) {
            issueHeaders.setEntityAudit(customerId, userId, recordType);
            issueHeaders.setSystemInformation(recordType);
        }
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
        if (this.issueAssignment != null) {
            issueAssignment.setEntityAudit(customerId, userId);
        }
        if (this.addWatchers == null) {
            this.addWatchers = new java.util.ArrayList<AddWatchers>();
        }
        for (AddWatchers _addWatchers : addWatchers) {
            _addWatchers.setEntityAudit(customerId, userId);
        }
        if (this.issueHeaders != null) {
            issueHeaders.setEntityAudit(customerId, userId);
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
            this.systemInfo.setActiveStatus(-1);
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
    public int compare(IssueWorkflow object1, IssueWorkflow object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((issueTitle == null ? " " : issueTitle) + ",");
        sb.append((issueDescription == null ? " " : issueDescription) + ",");
        sb.append((stepsToReproduce == null ? " " : stepsToReproduce) + ",");
        sb.append((creatorContactId.toString() == null ? " " : creatorContactId.toString()) + ",");
        sb.append((dateCreated == null ? " " : dateCreated) + ",");
        sb.append((projectId.toString() == null ? " " : projectId.toString()) + ",");
        sb.append((moduleId.toString() == null ? " " : moduleId.toString()) + ",");
        sb.append((featureId.toString() == null ? " " : featureId.toString()) + ",");
        sb.append((browser == null ? " " : browser) + ",");
        sb.append((oS == null ? " " : oS));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (issueId == null) {
            return super.hashCode();
        } else {
            return issueId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow other = (issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow) obj;
            if (issueId == null) {
                return false;
            } else if (!issueId.equals(other.issueId)) {
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
