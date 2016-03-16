package issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager;
import com.athena.server.repository.SearchInterface;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.util.List;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping;

@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for ProjectFeature Transaction table", complexity = Complexity.MEDIUM)
public interface ProjectFeatureRepository<T> extends SearchInterface {

    public List<T> findAll() throws SpartanPersistenceException;

    public T save(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> save(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void delete(String id) throws SpartanPersistenceException;

    public void deleteFeatureUserMapping(List<FeatureUserMapping> featureusermapping) throws SpartanPersistenceException;

    public void update(T entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public void update(List<T> entity) throws SpartanPersistenceException, SpartanConstraintViolationException;

    public List<T> findByModuleId(String moduleId) throws Exception, SpartanPersistenceException;

    public List<T> findByProjectId(String projectId) throws Exception, SpartanPersistenceException;

    public T findById(String featureId) throws Exception, SpartanPersistenceException;
}