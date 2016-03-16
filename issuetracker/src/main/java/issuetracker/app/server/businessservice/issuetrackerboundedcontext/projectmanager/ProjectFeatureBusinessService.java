package issuetracker.app.server.businessservice.issuetrackerboundedcontext.projectmanager;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProjectFeatureBusinessService {

    @Autowired
    private ProjectFeatureRepository projectFeatureRepository;

    public void update(ProjectFeature entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                projectFeatureRepository.delete(entity.getFeatureId());
            } else {
                projectFeatureRepository.deleteFeatureUserMapping(entity.getDeletedFeatureUserMappingList());
                projectFeatureRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<ProjectFeature> entity) throws SpartanPersistenceException {
        try {
            for (ProjectFeature _projectfeature : entity) {
                if (_projectfeature.isHardDelete()) {
                    projectFeatureRepository.delete(_projectfeature.getFeatureId());
                } else {
                    projectFeatureRepository.deleteFeatureUserMapping(_projectfeature.getDeletedFeatureUserMappingList());
                    projectFeatureRepository.update(_projectfeature);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
