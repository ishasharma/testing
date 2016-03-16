package issuetracker.app.server.businessservice.issuetrackerboundedcontext.projectmanager;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ProjectModuleBusinessService {

    @Autowired
    private ProjectModuleRepository projectModuleRepository;

    public void update(ProjectModule entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                projectModuleRepository.delete(entity.getModuleId());
            } else {
                projectModuleRepository.deleteModuleUserMapping(entity.getDeletedModuleUserMappingList());
                projectModuleRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<ProjectModule> entity) throws SpartanPersistenceException {
        try {
            for (ProjectModule _projectmodule : entity) {
                if (_projectmodule.isHardDelete()) {
                    projectModuleRepository.delete(_projectmodule.getModuleId());
                } else {
                    projectModuleRepository.deleteModuleUserMapping(_projectmodule.getDeletedModuleUserMappingList());
                    projectModuleRepository.update(_projectmodule);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
