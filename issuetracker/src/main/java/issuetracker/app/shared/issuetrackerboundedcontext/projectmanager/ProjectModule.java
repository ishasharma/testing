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

@Table(name = "ast_ProjectModule_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "ProjectModule", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "moduleId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "ProjectModule.findByProjectId", query = "select e from ProjectModule e where e.systemInfo.activeStatus=1 and e.projectId=:projectId"), @javax.persistence.NamedQuery(name = "ProjectModule.findById", query = "select e from ProjectModule e where e.systemInfo.activeStatus=1 and e.moduleId =:moduleId") })
public class ProjectModule implements Serializable, CommonEntityInterface, Comparator<ProjectModule> {

    @Column(name = "moduleName")
    @JsonProperty("moduleName")
    @NotNull
    @Size(min = 0, max = 128)
    private String moduleName;

    @Column(name = "moduleShortName")
    @JsonProperty("moduleShortName")
    @NotNull
    @Size(min = 0, max = 64)
    private String moduleShortName;

    @Column(name = "moduleDescription")
    @JsonProperty("moduleDescription")
    @NotNull
    @Size(min = 0, max = 256)
    private String moduleDescription;

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
    @Column(name = "moduleId")
    @JsonProperty("moduleId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String moduleId;

    @Column(name = "projectId")
    @JsonProperty("projectId")
    private String projectId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projectModule")
    private List<ModuleUserMapping> moduleUserMapping;

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

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String _moduleName) {
        if (_moduleName != null) {
            this.moduleName = _moduleName;
        }
    }

    public String getModuleShortName() {
        return moduleShortName;
    }

    public void setModuleShortName(String _moduleShortName) {
        if (_moduleShortName != null) {
            this.moduleShortName = _moduleShortName;
        }
    }

    public String getModuleDescription() {
        return moduleDescription;
    }

    public void setModuleDescription(String _moduleDescription) {
        if (_moduleDescription != null) {
            this.moduleDescription = _moduleDescription;
        }
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
        return moduleId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return moduleId;
    }

    public String getModuleId() {
        return moduleId;
    }

    public void setModuleId(String _moduleId) {
        this.moduleId = _moduleId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String _projectId) {
        this.projectId = _projectId;
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

    public ProjectModule addModuleUserMapping(ModuleUserMapping _moduleUserMapping) {
        if (this.moduleUserMapping == null) {
            this.moduleUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping>();
        }
        if (_moduleUserMapping != null) {
            _moduleUserMapping.setProjectModule(this);
            this.moduleUserMapping.add(_moduleUserMapping);
        }
        return this;
    }

    public ProjectModule removeModuleUserMapping(ModuleUserMapping _moduleUserMapping) {
        if (this.moduleUserMapping != null) {
            this.moduleUserMapping.remove(_moduleUserMapping);
        }
        return this;
    }

    public ProjectModule addAllModuleUserMapping(List<ModuleUserMapping> _moduleUserMapping) {
        if (this.moduleUserMapping == null) {
            this.moduleUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping>();
        }
        if (_moduleUserMapping != null) {
            for (int i = 0; i < _moduleUserMapping.size(); i++) {
                _moduleUserMapping.get(i).setProjectModule(this);
            }
            this.moduleUserMapping.addAll(_moduleUserMapping);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfModuleUserMapping() {
        if (this.moduleUserMapping != null) {
            return this.moduleUserMapping.size();
        }
        return 0;
    }

    public List<ModuleUserMapping> getModuleUserMapping() {
        return moduleUserMapping;
    }

    public void setModuleUserMapping(List<ModuleUserMapping> _moduleUserMapping) {
        for (int i = 0; i < _moduleUserMapping.size(); i++) {
            if (_moduleUserMapping.get(i).getProjectModule() == null) {
                _moduleUserMapping.get(i).setProjectModule(this);
            }
        }
        this.moduleUserMapping = _moduleUserMapping;
    }

    @JsonIgnore
    public List<ModuleUserMapping> getDeletedModuleUserMappingList() {
        List<ModuleUserMapping> moduleusermappingToRemove = new java.util.ArrayList<ModuleUserMapping>();
        for (ModuleUserMapping _moduleusermapping : moduleUserMapping) {
            if (_moduleusermapping.isHardDelete()) {
                moduleusermappingToRemove.add(_moduleusermapping);
            }
        }
        moduleUserMapping.removeAll(moduleusermappingToRemove);
        return moduleusermappingToRemove;
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
        setValidatormoduleUserMapping(_validateFactory);
    }

    private void setValidatormoduleUserMapping(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < moduleUserMapping.size(); i++) {
            moduleUserMapping.get(i).setEntityValidator(_validateFactory);
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
        if (this.moduleUserMapping == null) {
            this.moduleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        }
        for (ModuleUserMapping _moduleUserMapping : moduleUserMapping) {
            _moduleUserMapping.setEntityAudit(customerId, userId, recordType);
            _moduleUserMapping.setSystemInformation(recordType);
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
        if (this.moduleUserMapping == null) {
            this.moduleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        }
        for (ModuleUserMapping _moduleUserMapping : moduleUserMapping) {
            _moduleUserMapping.setEntityAudit(customerId, userId);
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
    public int compare(ProjectModule object1, ProjectModule object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((moduleName == null ? " " : moduleName) + ",");
        sb.append((moduleShortName == null ? " " : moduleShortName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (moduleId == null) {
            return super.hashCode();
        } else {
            return moduleId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule other = (issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule) obj;
            if (moduleId == null) {
                return false;
            } else if (!moduleId.equals(other.moduleId)) {
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
