package sales.app.server.repository.organizationboundedcontext.location;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for State Master table Entity", complexity = Complexity.LOW)
public interface StateRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByCountryId(String countryId) throws Exception, SpartanPersistenceException;

    public T findById(String stateId) throws Exception, SpartanPersistenceException;
}
