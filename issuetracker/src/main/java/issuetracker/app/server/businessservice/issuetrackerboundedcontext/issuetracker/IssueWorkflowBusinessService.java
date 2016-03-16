package issuetracker.app.server.businessservice.issuetrackerboundedcontext.issuetracker;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class IssueWorkflowBusinessService {

    @Autowired
    private IssueWorkflowRepository issueWorkflowRepository;

    public void update(IssueWorkflow entity) throws SpartanPersistenceException {
        try {
            if (entity.isHardDelete()) {
                issueWorkflowRepository.delete(entity.getIssueId());
            } else {
                issueWorkflowRepository.deleteAddWatchers(entity.getDeletedAddWatchersList());
                issueWorkflowRepository.update(entity);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    public void update(List<IssueWorkflow> entity) throws SpartanPersistenceException {
        try {
            for (IssueWorkflow _issueworkflow : entity) {
                if (_issueworkflow.isHardDelete()) {
                    issueWorkflowRepository.delete(_issueworkflow.getIssueId());
                } else {
                    issueWorkflowRepository.deleteAddWatchers(_issueworkflow.getDeletedAddWatchersList());
                    issueWorkflowRepository.update(_issueworkflow);
                }
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in updating Entity", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }
}
