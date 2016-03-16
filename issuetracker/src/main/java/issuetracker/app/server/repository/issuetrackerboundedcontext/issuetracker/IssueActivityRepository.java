package issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for IssueActivity Master table Entity", complexity = Complexity.LOW)
public interface IssueActivityRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByIssueStageCode(String issueStageCode) throws Exception, SpartanPersistenceException;

    public List<T> findByIssueStatusCode(String issueStatusCode) throws Exception, SpartanPersistenceException;

    public T findById(String issueActivityCode) throws Exception, SpartanPersistenceException;
}