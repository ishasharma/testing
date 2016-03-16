package issuetracker.app.server.service.issuetrackerboundedcontext.projectmanager;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.WorkflowUserRoleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.WorkflowUserRole;
import org.springframework.beans.factory.annotation.Autowired;
import com.athena.framework.server.helper.RuntimeLogInfoHelper;
import com.athena.framework.server.helper.EntityValidatorHelper;
import com.athena.framework.server.test.RandomValueGenerator;
import java.util.HashMap;
import java.util.List;
import com.spartan.healthmeter.entity.scheduler.ArtMethodCallStack;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.junit.Before;
import org.junit.After;
import com.athena.framework.shared.entity.web.entityInterface.CommonEntityInterface.RECORD_TYPE;
import org.junit.Test;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectRoles;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectRolesRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.Workflow;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.WorkflowRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class WorkflowUserRoleTestCase extends EntityTestCriteria {

    @Autowired
    private WorkflowUserRoleRepository<WorkflowUserRole> workflowuserroleRepository;

    @Autowired
    private RuntimeLogInfoHelper runtimeLogInfoHelper;

    @Autowired
    private EntityValidatorHelper<Object> entityValidator;

    private RandomValueGenerator valueGenerator = new RandomValueGenerator();

    private static HashMap<String, Object> map = new HashMap<String, Object>();

    private static List<EntityTestCriteria> entityContraint;

    @Autowired
    private ArtMethodCallStack methodCallStack;

    protected MockHttpSession session;

    protected MockHttpServletRequest request;

    protected MockHttpServletResponse response;

    protected void startSession() {
        session = new MockHttpSession();
    }

    protected void endSession() {
        session.clearAttributes();
        session.invalidate();
        session = null;
    }

    protected void startRequest() {
        request = new MockHttpServletRequest();
        request.setSession(session);
        org.springframework.web.context.request.RequestContextHolder.setRequestAttributes(new org.springframework.web.context.request.ServletRequestAttributes(request));
    }

    protected void endRequest() {
        ((org.springframework.web.context.request.ServletRequestAttributes) org.springframework.web.context.request.RequestContextHolder.getRequestAttributes()).requestCompleted();
        org.springframework.web.context.request.RequestContextHolder.resetRequestAttributes();
        request = null;
    }

    @Before
    public void before() {
        startSession();
        startRequest();
        setBeans();
    }

    @After
    public void after() {
        endSession();
        endRequest();
    }

    private void setBeans() {
        runtimeLogInfoHelper.createRuntimeLogUserInfo(1, "AAAAA", request.getRemoteHost());
        org.junit.Assert.assertNotNull(runtimeLogInfoHelper);
        methodCallStack.setRequestId(java.util.UUID.randomUUID().toString().toUpperCase());
        entityContraint = addingListOfFieldForNegativeTesting();
    }

    private WorkflowUserRole createWorkflowUserRole() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectRoles projectroles = new ProjectRoles();
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("KP7Xplqgi57y0fhqkffdcRMqDY9yghDjOJag064DLNilQGeztb");
        issuevisibility.setIssueVisibilityDesc("oj7vvOj8NUDum6URJsfbqZU0jPoKNEmKDe0ImzrkQ7ALtPeS1j");
        IssueVisibility IssueVisibilityTest = issuevisibilityRepository.save(issuevisibility);
        map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        projectroles.setIssueVisibilityCode((java.lang.String) IssueVisibilityTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectroles.setCanAssignRole(true);
        projectroles.setRoleName("1or4Dj66mmB3UoG8IjTQBdRimePOjMIK8BtoYMwTTt8cbYZl4r");
        ProjectRoles ProjectRolesTest = projectrolesRepository.save(projectroles);
        map.put("ProjectRolesPrimaryKey", projectroles._getPrimarykey());
        Workflow workflow = new Workflow();
        workflow.setWorkflowName("8tXGW0luUdDkWKfBCyTqUDyK6eJZUGVgrLfPadSqb173KGIyRB");
        Workflow WorkflowTest = workflowRepository.save(workflow);
        map.put("WorkflowPrimaryKey", workflow._getPrimarykey());
        WorkflowUserRole workflowuserrole = new WorkflowUserRole();
        workflowuserrole.setPrjRoleId((java.lang.String) ProjectRolesTest._getPrimarykey()); /* ******Adding refrenced table data */
        workflowuserrole.setWorkflowId((java.lang.String) WorkflowTest._getPrimarykey());
        workflowuserrole.setEntityValidator(entityValidator);
        return workflowuserrole;
    }

    @Test
    public void test1Save() {
        try {
            WorkflowUserRole workflowuserrole = createWorkflowUserRole();
            workflowuserrole.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            workflowuserrole.isValid();
            workflowuserroleRepository.save(workflowuserrole);
            map.put("WorkflowUserRolePrimaryKey", workflowuserrole._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ProjectRolesRepository<ProjectRoles> projectrolesRepository;

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

    @Autowired
    private WorkflowRepository<Workflow> workflowRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            WorkflowUserRole workflowuserrole = workflowuserroleRepository.findById((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
            workflowuserrole.setVersionId(1);
            workflowuserrole.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            workflowuserroleRepository.update(workflowuserrole);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprjRoleId() {
        try {
            java.util.List<WorkflowUserRole> listofprjRoleId = workflowuserroleRepository.findByPrjRoleId((java.lang.String) map.get("ProjectRolesPrimaryKey"));
            if (listofprjRoleId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            workflowuserroleRepository.findById((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByworkflowId() {
        try {
            java.util.List<WorkflowUserRole> listofworkflowId = workflowuserroleRepository.findByWorkflowId((java.lang.String) map.get("WorkflowPrimaryKey"));
            if (listofworkflowId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("WorkflowUserRolePrimaryKey"));
            workflowuserroleRepository.delete((java.lang.String) map.get("WorkflowUserRolePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateWorkflowUserRole(EntityTestCriteria contraints, WorkflowUserRole workflowuserrole) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            workflowuserrole.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            workflowuserrole.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            workflowuserroleRepository.save(workflowuserrole);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
    }
}
