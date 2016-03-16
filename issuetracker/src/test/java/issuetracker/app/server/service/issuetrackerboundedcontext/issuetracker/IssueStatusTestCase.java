package issuetracker.app.server.service.issuetrackerboundedcontext.issuetracker;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
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
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueStatusTestCase extends EntityTestCriteria {

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

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

    private IssueStatus createIssueStatus() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("ASf52WhrLCO2w4CWS7AeGZvS0NqXonseMMl9ZNQfHyTog70PGF");
        issuestage.setIssueStageId("NrWxj5P4yf7MHK0MROAqC3Va0FQ3oEZcJJ7aAw1agevz0RnEED");
        issuestage.setIssueStageDesc("f0FpEDehQMmLHqgKKSgynojV1Ab8ME5OQCQdZnHQTKVPOQfBvE");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusDesc("WOjtqiHJfvWIsho8t5L7f7DVCQUaS0YhGQQlPsMkYHdR3t3kbY");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("SWi9ZvUN71LhkpPwWhxSfat36YXdtWySZmtuGq2ItWzwrMS3EN");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey());
        issuestatus.setEntityValidator(entityValidator);
        return issuestatus;
    }

    @Test
    public void test1Save() {
        try {
            IssueStatus issuestatus = createIssueStatus();
            issuestatus.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuestatus.isValid();
            issuestatusRepository.save(issuestatus);
            map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            IssueStatus issuestatus = issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
            issuestatus.setIssueStatusDesc("I49D6GJqBAHUpB9W09g5YiApmJeKVK2Qs1DQKncLBlwiwSZkLe");
            issuestatus.setIssueStatusId("5qEbxmPehchBG6AfwfZPmpvJfGNTc5UTmt6EkLw5PEObJnw11p");
            issuestatus.setVersionId(1);
            issuestatus.setIssueStatusName("4AVAd8XQesE6CuxAxRQv1XEnbrsp80wNPj8MSbeA2Bf83FmUGy");
            issuestatus.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuestatusRepository.update(issuestatus);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueStatus> listofissueStageCode = issuestatusRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
            if (listofissueStageCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueStatusPrimaryKey"));
            issuestatusRepository.delete((java.lang.String) map.get("IssueStatusPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueStatus(EntityTestCriteria contraints, IssueStatus issuestatus) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuestatus.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuestatus.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuestatusRepository.save(issuestatus);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "issueStatusId", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "issueStatusId", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "issueStatusId", "12yFQcMHnO2TlfxHYkfly9CNQG1f2qmDZgyHuaqcgOKzvQKt51kYf1eK05wqI0gKj"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "issueStatusName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "issueStatusName", "rEQ0NPosHKUpT1y5n8k8Iewr4qE0Vxx2T0JtQfUfu61WUwupdMwH3NIKPnz4IEJCIhioUJCwycF0ID4Fc8sgbvknsdQwpWsVWIQNb3vCfuvryl4SJpSuzoTuqZTeJ0UeCV93mXWl1GOOWO6kQbBi7lWuP6ZSrH1lNrx4QsjdEGxuTMirxH9Xs91uuUDrnjPT2WjindWErCwnscXuijbeFJye10MlOLHRmIIdoDW3yzGaPhjia6JmmVAimgIjLx3tJ"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "issueStatusDesc", "7QZmfc9zXAsho3h6CsSQSddyTUSQZVdhreS50MOlpeHxyi1f9LRqhVNHLgUe4lxGSjhIx7aA843YJ9NH3kFfduS7t0s6Sv2ac6hu0Tbw8NtGIBLhsWnhDih4zgAt55Unf6tf6f67KjQ198zGOQrcADZspQYsMo53zmfWjLKaxNkh5t269xmxKPCIDD4ZsGdbeuzyG0bLPGnXA6VxrIvaDbgL5P2meVUbUN5M57eqIdopNryPi0i7fHVKFjgQniWjleUEjq78mfK3eLvmls0CgV2ePeo0WU8ejyFmqBCpbqT0M47TYm2alU0oPvoZGrw96GbaT544cL2H71mk0r8yrkJfx1asboyxbxk3cqJPaNIla1yG16Yv7Qgo3ItHo5ogofCDOMgSrOvZMqmlllRHRubvRhjuLoJ3mLvaojdXCLt5sqTfTJVdLICWYDnOFCCJcmLxThcCKcz3bSpx1YDa4cSgG3C087H8cGEVIi6gxAYCsO2b3raoelHxeCSPDqLTnbzdEQq38NnmIc9ZbUAuedgR0ELOycm5seHOkqeaRzSTe0sLghGFTnJzBACpsNCrLbmOYM2fHv1NbqquBNkQPVmW5TEDT7IrELYKnyp64vrRdsZIUCPpSlEZgQ1TsrrF7JIGjRhUb8XmkFXbt8wajC6yoMCdepFsaJ35vwBZ8qpTlN3gJ6Bxh2eSgTGKePkilEMAcJ3NvtZK4oI5vJG3jP2lTMVPbPV1s9Rjzt3A65iAy0MmRx0c2H7gxGLSknMBKvovGCqjPX3yeXxJX2yWXMX9uoRJu5BY2p8Hqodk2znWiGMLhf0G1moq7hCHk49uSYMoWGczFuOx7BPr2KT3QpjOBrSuX8bZLf8oDMNdTnsw1s10wDg4YARHMLIz5tfapCe0E232cxQVj3O4QTBDcT4VZyo0zXZOmeTdm4QwPoXfeKOPCqSpIECalRUNJUrUh6udG4g8eVTpTHWZ1lGJnFUbePCfYnwVqvbvdWM8ZvJXJba9zGAT56KTP1ojgYpjm"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueStatus issuestatus = createIssueStatus();
                java.lang.reflect.Field field = issuestatus.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuestatus, null);
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 2:
                        IssueStatus issuestatusUnique = issuestatusRepository.findById((java.lang.String) map.get("IssueStatusPrimaryKey"));
                        issuestatus.setIssueStatusId(issuestatusUnique.getIssueStatusId());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 3:
                        issuestatus.setIssueStatusId(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(issuestatus, null);
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 5:
                        issuestatus.setIssueStatusName(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                    case 6:
                        issuestatus.setIssueStatusDesc(contraints.getNegativeValue().toString());
                        validateIssueStatus(contraints, issuestatus);
                        failureCount++;
                        break;
                }
            } catch (SpartanIncorrectDataException e) {
                e.printStackTrace();
            } catch (SpartanConstraintViolationException e) {
                e.printStackTrace();
            } catch (SpartanPersistenceException e) {
                e.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (failureCount > 0) {
            org.junit.Assert.fail();
        }
    }
}
