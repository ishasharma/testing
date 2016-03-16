package issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker;
import com.athena.server.repository.SearchInterfaceImpl;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
import org.springframework.stereotype.Repository;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import com.athena.annotation.Complexity;
import com.athena.annotation.SourceCodeAuthorClass;
import com.athena.config.server.helper.ResourceFactoryManagerHelper;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;
import java.lang.Override;
import java.util.List;
import org.springframework.transaction.annotation.Transactional;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers;

@Repository
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
@SourceCodeAuthorClass(createdBy = "root", updatedBy = "", versionNumber = "1", comments = "Repository for IssueWorkflow Transaction table", complexity = Complexity.MEDIUM)
public class IssueWorkflowRepositoryImpl extends SearchInterfaceImpl implements IssueWorkflowRepository<IssueWorkflow> {

    @Autowired
    private ResourceFactoryManagerHelper emfResource;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Override
    @Transactional
    public List<IssueWorkflow> findAll() throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow> query = emanager.createQuery("select u from IssueWorkflow u where u.systemInfo.activeStatus=1").getResultList();
            return query;
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in retrieving entity", e);
        }
    }

    @Override
    @Transactional
    public IssueWorkflow save(IssueWorkflow entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.persist(entity);
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        }
    }

    @Override
    @Transactional
    public List<IssueWorkflow> save(List<IssueWorkflow> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow obj = entity.get(i);
                emanager.persist(obj);
            }
            return entity;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity Saving", e);
        }
    }

    @Transactional
    @Override
    public void delete(String id) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow s = emanager.find(issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow.class, id);
            emanager.remove(s);
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void deleteAddWatchers(List<AddWatchers> addwatchers) throws SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers _addwatchers : addwatchers) {
                issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers s = emanager.find(issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers.class, _addwatchers.getWatchId());
                emanager.remove(s);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new SpartanPersistenceException("Error in deleting entity", e);
        }
    }

    @Override
    @Transactional
    public void update(IssueWorkflow entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            emanager.merge(entity);
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity creation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Override
    @Transactional
    public void update(List<IssueWorkflow> entity) throws SpartanPersistenceException, SpartanConstraintViolationException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            for (int i = 0; i < entity.size(); i++) {
                issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow obj = entity.get(i);
                emanager.merge(obj);
            }
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in entity updation", e);
        } catch (Exception e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error while updating entity", e);
        }
    }

    @Transactional
    public List<IssueWorkflow> findByCreatorContactId(String creatorContactId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("IssueWorkflow.findByCreatorContactId");
            query.setParameter("creatorContactId", creatorContactId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow> listOfIssueWorkflow = query.getResultList();
            return listOfIssueWorkflow;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<IssueWorkflow> findByProjectId(String projectId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("IssueWorkflow.findByProjectId");
            query.setParameter("projectId", projectId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow> listOfIssueWorkflow = query.getResultList();
            return listOfIssueWorkflow;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<IssueWorkflow> findByModuleId(String moduleId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("IssueWorkflow.findByModuleId");
            query.setParameter("moduleId", moduleId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow> listOfIssueWorkflow = query.getResultList();
            return listOfIssueWorkflow;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public List<IssueWorkflow> findByFeatureId(String featureId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("IssueWorkflow.findByFeatureId");
            query.setParameter("featureId", featureId);
            java.util.List<issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow> listOfIssueWorkflow = query.getResultList();
            return listOfIssueWorkflow;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }

    @Transactional
    public IssueWorkflow findById(String issueId) throws Exception, SpartanPersistenceException {
        try {
            javax.persistence.EntityManager emanager = emfResource.getResource();
            javax.persistence.Query query = emanager.createNamedQuery("IssueWorkflow.findById");
            query.setParameter("issueId", issueId);
            issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow listOfIssueWorkflow = (issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow) query.getSingleResult();
            return listOfIssueWorkflow;
        } catch (javax.persistence.PersistenceException e) {
            throw new com.athena.framework.server.exception.repository.SpartanPersistenceException("Error in executing query", e);
        }
    }
}
