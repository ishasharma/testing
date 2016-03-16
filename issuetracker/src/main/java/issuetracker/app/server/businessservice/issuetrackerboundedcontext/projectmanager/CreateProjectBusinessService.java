package issuetracker.app.server.businessservice.issuetrackerboundedcontext.projectmanager;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class CreateProjectBusinessService {

    @Autowired
    private CreateProjectRepository createProjectRepository;

    public void update(CreateProject entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                createProjectRepository.delete(entity.getProjectId());
            } else {
                createProjectRepository.deleteProjectUserMapping(entity.getDeletedProjectUserMappingList());
                createProjectRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<CreateProject> entity) throws SpartanPersistenceException {
        try {
            for (CreateProject _createproject : entity) {
                if (_createproject.isHardDelete()) {
                    createProjectRepository.delete(_createproject.getProjectId());
                } else {
                    createProjectRepository.deleteProjectUserMapping(_createproject.getDeletedProjectUserMappingList());
                    createProjectRepository.update(_createproject);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
