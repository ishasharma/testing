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
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.FetchType;
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

@Table(name = "ast_CreateProject_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "CreateProject", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "projectId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "CreateProject.findByProjectAccessCode", query = "select e from CreateProject e where e.systemInfo.activeStatus=1 and e.projectAccessCode=:projectAccessCode"), @javax.persistence.NamedQuery(name = "CreateProject.findById", query = "select e from CreateProject e where e.systemInfo.activeStatus=1 and e.projectId =:projectId") })
public class CreateProject implements Serializable, CommonEntityInterface, Comparator<CreateProject> {

    @Column(name = "projectName")
    @JsonProperty("projectName")
    @NotNull
    @Size(min = 0, max = 128)
    private String projectName;

    @Column(name = "projectShortName")
    @JsonProperty("projectShortName")
    @NotNull
    @Size(min = 0, max = 64)
    private String projectShortName;

    @Column(name = "projectDescription")
    @JsonProperty("projectDescription")
    @NotNull
    @Size(min = 0, max = 1024)
    private String projectDescription;

    @Column(name = "projectURL")
    @JsonProperty("projectURL")
    @Size(min = 0, max = 64)
    private String projectURL;

    @Column(name = "version")
    @JsonProperty("version")
    @Size(min = 0, max = 64)
    private String version;

    @Column(name = "build")
    @JsonProperty("build")
    @Size(min = 0, max = 64)
    private String build;

    @Column(name = "dateOfCreation")
    @JsonProperty("dateOfCreation")
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date dateOfCreation;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "projectId")
    @JsonProperty("projectId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String projectId;

    @Column(name = "projectAccessCode")
    @JsonProperty("projectAccessCode")
    private String projectAccessCode;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "createProject")
    private List<ProjectUserMapping> projectUserMapping;

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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String _projectName) {
        if (_projectName != null) {
            this.projectName = _projectName;
        }
    }

    public String getProjectShortName() {
        return projectShortName;
    }

    public void setProjectShortName(String _projectShortName) {
        if (_projectShortName != null) {
            this.projectShortName = _projectShortName;
        }
    }

    public String getProjectDescription() {
        return projectDescription;
    }

    public void setProjectDescription(String _projectDescription) {
        if (_projectDescription != null) {
            this.projectDescription = _projectDescription;
        }
    }

    public String getProjectURL() {
        return projectURL;
    }

    public void setProjectURL(String _projectURL) {
        this.projectURL = _projectURL;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String _version) {
        this.version = _version;
    }

    public String getBuild() {
        return build;
    }

    public void setBuild(String _build) {
        this.build = _build;
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date _dateOfCreation) {
        this.dateOfCreation = _dateOfCreation;
    }

    public String getPrimaryKey() {
        return projectId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return projectId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String _projectId) {
        this.projectId = _projectId;
    }

    public String getProjectAccessCode() {
        return projectAccessCode;
    }

    public void setProjectAccessCode(String _projectAccessCode) {
        this.projectAccessCode = _projectAccessCode;
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

    public CreateProject addProjectUserMapping(ProjectUserMapping _projectUserMapping) {
        if (this.projectUserMapping == null) {
            this.projectUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping>();
        }
        if (_projectUserMapping != null) {
            _projectUserMapping.setCreateProject(this);
            this.projectUserMapping.add(_projectUserMapping);
        }
        return this;
    }

    public CreateProject removeProjectUserMapping(ProjectUserMapping _projectUserMapping) {
        if (this.projectUserMapping != null) {
            this.projectUserMapping.remove(_projectUserMapping);
        }
        return this;
    }

    public CreateProject addAllProjectUserMapping(List<ProjectUserMapping> _projectUserMapping) {
        if (this.projectUserMapping == null) {
            this.projectUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping>();
        }
        if (_projectUserMapping != null) {
            for (int i = 0; i < _projectUserMapping.size(); i++) {
                _projectUserMapping.get(i).setCreateProject(this);
            }
            this.projectUserMapping.addAll(_projectUserMapping);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfProjectUserMapping() {
        if (this.projectUserMapping != null) {
            return this.projectUserMapping.size();
        }
        return 0;
    }

    public List<ProjectUserMapping> getProjectUserMapping() {
        return projectUserMapping;
    }

    public void setProjectUserMapping(List<ProjectUserMapping> _projectUserMapping) {
        for (int i = 0; i < _projectUserMapping.size(); i++) {
            if (_projectUserMapping.get(i).getCreateProject() == null) {
                _projectUserMapping.get(i).setCreateProject(this);
            }
        }
        this.projectUserMapping = _projectUserMapping;
    }

    @JsonIgnore
    public List<ProjectUserMapping> getDeletedProjectUserMappingList() {
        List<ProjectUserMapping> projectusermappingToRemove = new java.util.ArrayList<ProjectUserMapping>();
        for (ProjectUserMapping _projectusermapping : projectUserMapping) {
            if (_projectusermapping.isHardDelete()) {
                projectusermappingToRemove.add(_projectusermapping);
            }
        }
        projectUserMapping.removeAll(projectusermappingToRemove);
        return projectusermappingToRemove;
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
        setValidatorprojectUserMapping(_validateFactory);
    }

    private void setValidatorprojectUserMapping(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < projectUserMapping.size(); i++) {
            projectUserMapping.get(i).setEntityValidator(_validateFactory);
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
        if (this.projectUserMapping == null) {
            this.projectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        }
        for (ProjectUserMapping _projectUserMapping : projectUserMapping) {
            _projectUserMapping.setEntityAudit(customerId, userId, recordType);
            _projectUserMapping.setSystemInformation(recordType);
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
        if (this.projectUserMapping == null) {
            this.projectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        }
        for (ProjectUserMapping _projectUserMapping : projectUserMapping) {
            _projectUserMapping.setEntityAudit(customerId, userId);
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
    public int compare(CreateProject object1, CreateProject object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((projectName == null ? " " : projectName) + ",");
        sb.append((projectShortName == null ? " " : projectShortName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (projectId == null) {
            return super.hashCode();
        } else {
            return projectId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject other = (issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject) obj;
            if (projectId == null) {
                return false;
            } else if (!projectId.equals(other.projectId)) {
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
