package issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for IssueRelation Master table Entity", complexity = Complexity.LOW)
public interface IssueRelationRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByIssueId(String issueId) throws Exception, SpartanPersistenceException;

    public List<T> findByIssueRelationId(String issueRelationId) throws Exception, SpartanPersistenceException;

    public List<T> findByRelationCode(String relationCode) throws Exception, SpartanPersistenceException;

    public T findById(String relationId) throws Exception, SpartanPersistenceException;
}
