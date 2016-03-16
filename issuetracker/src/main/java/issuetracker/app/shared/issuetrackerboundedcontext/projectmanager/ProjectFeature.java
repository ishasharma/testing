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
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;
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

@Table(name = "ast_ProjectFeature_T")
@Entity
@Cache(type = CacheType.CACHE, isolation = CacheIsolationType.ISOLATED)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "ProjectFeature", complexity = Complexity.LOW)
@JsonIdentityInfo(generator = PropertyGenerator.class, property = "featureId")
@NamedQueries({ @javax.persistence.NamedQuery(name = "ProjectFeature.findByModuleId", query = "select e from ProjectFeature e where e.systemInfo.activeStatus=1 and e.moduleId=:moduleId"), @javax.persistence.NamedQuery(name = "ProjectFeature.findByProjectId", query = "select e from ProjectFeature e where e.systemInfo.activeStatus=1 and e.projectId=:projectId"), @javax.persistence.NamedQuery(name = "ProjectFeature.findById", query = "select e from ProjectFeature e where e.systemInfo.activeStatus=1 and e.featureId =:featureId") })
public class ProjectFeature implements Serializable, CommonEntityInterface, Comparator<ProjectFeature> {

    @Column(name = "featureName")
    @JsonProperty("featureName")
    @NotNull
    @Size(min = 0, max = 128)
    private String featureName;

    @Column(name = "featureShortName")
    @JsonProperty("featureShortName")
    @NotNull
    @Size(min = 0, max = 64)
    private String featureShortName;

    @Column(name = "featureDescription")
    @JsonProperty("featureDescription")
    @NotNull
    @Size(min = 0, max = 256)
    private String featureDescription;

    @Column(name = "version")
    @JsonProperty("version")
    @NotNull
    @Min(0)
    @Max(11)
    private Integer version;

    @Column(name = "build")
    @JsonProperty("build")
    @NotNull
    @Min(0)
    @Max(11)
    private Integer build;

    @Column(name = "dateOfCreation")
    @JsonProperty("dateOfCreation")
    @NotNull
    @JsonSerialize(using = CustomJsonDateSerializer.class)
    @JsonDeserialize(using = CustomJsonDateDeserializer.class)
    private Date dateOfCreation;

    @Transient
    private String primaryKey;

    @Id
    @Column(name = "featureId")
    @JsonProperty("featureId")
    @GeneratedValue(generator = "UUIDGenerator")
    @Size(min = 0, max = 64)
    private String featureId;

    @Column(name = "moduleId")
    @JsonProperty("moduleId")
    private String moduleId;

    @Column(name = "projectId")
    @JsonProperty("projectId")
    private String projectId;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "projectFeature")
    private List<FeatureUserMapping> featureUserMapping;

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

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String _featureName) {
        if (_featureName != null) {
            this.featureName = _featureName;
        }
    }

    public String getFeatureShortName() {
        return featureShortName;
    }

    public void setFeatureShortName(String _featureShortName) {
        if (_featureShortName != null) {
            this.featureShortName = _featureShortName;
        }
    }

    public String getFeatureDescription() {
        return featureDescription;
    }

    public void setFeatureDescription(String _featureDescription) {
        if (_featureDescription != null) {
            this.featureDescription = _featureDescription;
        }
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer _version) {
        if (_version != null) {
            this.version = _version;
        }
    }

    public Integer getBuild() {
        return build;
    }

    public void setBuild(Integer _build) {
        if (_build != null) {
            this.build = _build;
        }
    }

    public Date getDateOfCreation() {
        return dateOfCreation;
    }

    public void setDateOfCreation(Date _dateOfCreation) {
        if (_dateOfCreation != null) {
            this.dateOfCreation = _dateOfCreation;
        }
    }

    public String getPrimaryKey() {
        return featureId;
    }

    public void setPrimaryKey(String _primaryKey) {
        this.primaryKey = _primaryKey;
    }

    public String _getPrimarykey() {
        return featureId;
    }

    public String getFeatureId() {
        return featureId;
    }

    public void setFeatureId(String _featureId) {
        this.featureId = _featureId;
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

    public ProjectFeature addFeatureUserMapping(FeatureUserMapping _featureUserMapping) {
        if (this.featureUserMapping == null) {
            this.featureUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping>();
        }
        if (_featureUserMapping != null) {
            _featureUserMapping.setProjectFeature(this);
            this.featureUserMapping.add(_featureUserMapping);
        }
        return this;
    }

    public ProjectFeature removeFeatureUserMapping(FeatureUserMapping _featureUserMapping) {
        if (this.featureUserMapping != null) {
            this.featureUserMapping.remove(_featureUserMapping);
        }
        return this;
    }

    public ProjectFeature addAllFeatureUserMapping(List<FeatureUserMapping> _featureUserMapping) {
        if (this.featureUserMapping == null) {
            this.featureUserMapping = new java.util.ArrayList<issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping>();
        }
        if (_featureUserMapping != null) {
            for (int i = 0; i < _featureUserMapping.size(); i++) {
                _featureUserMapping.get(i).setProjectFeature(this);
            }
            this.featureUserMapping.addAll(_featureUserMapping);
        }
        return this;
    }

    @JsonIgnore
    public Integer getTotalNumberOfFeatureUserMapping() {
        if (this.featureUserMapping != null) {
            return this.featureUserMapping.size();
        }
        return 0;
    }

    public List<FeatureUserMapping> getFeatureUserMapping() {
        return featureUserMapping;
    }

    public void setFeatureUserMapping(List<FeatureUserMapping> _featureUserMapping) {
        for (int i = 0; i < _featureUserMapping.size(); i++) {
            if (_featureUserMapping.get(i).getProjectFeature() == null) {
                _featureUserMapping.get(i).setProjectFeature(this);
            }
        }
        this.featureUserMapping = _featureUserMapping;
    }

    @JsonIgnore
    public List<FeatureUserMapping> getDeletedFeatureUserMappingList() {
        List<FeatureUserMapping> featureusermappingToRemove = new java.util.ArrayList<FeatureUserMapping>();
        for (FeatureUserMapping _featureusermapping : featureUserMapping) {
            if (_featureusermapping.isHardDelete()) {
                featureusermappingToRemove.add(_featureusermapping);
            }
        }
        featureUserMapping.removeAll(featureusermappingToRemove);
        return featureusermappingToRemove;
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
        setValidatorfeatureUserMapping(_validateFactory);
    }

    private void setValidatorfeatureUserMapping(EntityValidatorHelper<Object> _validateFactory) {
        for (int i = 0; i < featureUserMapping.size(); i++) {
            featureUserMapping.get(i).setEntityValidator(_validateFactory);
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
        if (this.featureUserMapping == null) {
            this.featureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        }
        for (FeatureUserMapping _featureUserMapping : featureUserMapping) {
            _featureUserMapping.setEntityAudit(customerId, userId, recordType);
            _featureUserMapping.setSystemInformation(recordType);
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
        if (this.featureUserMapping == null) {
            this.featureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        }
        for (FeatureUserMapping _featureUserMapping : featureUserMapping) {
            _featureUserMapping.setEntityAudit(customerId, userId);
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
    public int compare(ProjectFeature object1, ProjectFeature object2) {
        return 0;
    }

    public String getPrimaryDisplay() {
        StringBuilder sb = new StringBuilder();
        sb.append("");
        sb.append((featureName == null ? " " : featureName) + ",");
        sb.append((featureShortName == null ? " " : featureShortName));
        return sb.toString();
    }

    public String toString() {
        return getPrimaryDisplay();
    }

    public int hashCode() {
        if (featureId == null) {
            return super.hashCode();
        } else {
            return featureId.hashCode();
        }
    }

    public boolean equals(Object obj) {
        try {
            issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature other = (issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature) obj;
            if (featureId == null) {
                return false;
            } else if (!featureId.equals(other.featureId)) {
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
