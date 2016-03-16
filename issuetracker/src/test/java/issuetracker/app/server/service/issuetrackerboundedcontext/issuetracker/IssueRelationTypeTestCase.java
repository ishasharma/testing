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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueRelationTypeRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueRelationType;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueRelationTypeTestCase extends EntityTestCriteria {

    @Autowired
    private IssueRelationTypeRepository<IssueRelationType> issuerelationtypeRepository;

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

    private IssueRelationType createIssueRelationType() throws SpartanPersistenceException, SpartanConstraintViolationException {
        IssueRelationType issuerelationtype = new IssueRelationType();
        issuerelationtype.setRelationDesc("IDlBK08M4JpBM6iFMjupALiY6TZSkNRBPjsyRZ5kWRZdS9qUfw");
        issuerelationtype.setRelationName("Pi0cL5YrdSll9DqRP3FTCHmbQwA2VRGTcsf82r1tkjahMrdh29");
        issuerelationtype.setEntityValidator(entityValidator);
        return issuerelationtype;
    }

    @Test
    public void test1Save() {
        try {
            IssueRelationType issuerelationtype = createIssueRelationType();
            issuerelationtype.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuerelationtype.isValid();
            issuerelationtypeRepository.save(issuerelationtype);
            map.put("IssueRelationTypePrimaryKey", issuerelationtype._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            IssueRelationType issuerelationtype = issuerelationtypeRepository.findById((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
            issuerelationtype.setRelationDesc("1AKIIeHthK3ut2NrCEJaCxHSMG7zW7SnI9K83GETYnjyhzNoSF");
            issuerelationtype.setRelationName("K3pj63GMnKI8FgiEDVepwliah70P6vd56HIZOBgAVyem42VH6H");
            issuerelationtype.setVersionId(1);
            issuerelationtype.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuerelationtypeRepository.update(issuerelationtype);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            issuerelationtypeRepository.findById((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueRelationTypePrimaryKey"));
            issuerelationtypeRepository.delete((java.lang.String) map.get("IssueRelationTypePrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueRelationType(EntityTestCriteria contraints, IssueRelationType issuerelationtype) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuerelationtype.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuerelationtype.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuerelationtypeRepository.save(issuerelationtype);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "relationName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "relationName", "tCPxBZ2huaL8lK1k6gBHcPIFA7iyEtWR6VTCKvPsGconpgdVC5HUbqRKwtBW2jVSPAkeLR5jf4xqSyLIW7MfWnadFVayBPzM3ceTrb92Rm6kFeWouEdg5ksTzjYnHKBsjLH9Bau0mw1xsMNgEpmSNx1VoLzgRtt5jhwUB1Ti7DGYrdhfVbEYlPGvPYLNStAjLzDnifXsOtLWrUjje69nzUJ1Jaddj9hRjHXKBoHiRWi8bc6B5KDen4DcsmYvA3WcS"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "relationDesc", "XyWOZgPjJLXpIadi2IPYGBim2a4Ftn6JUfE57l3lu8DQIa92uH7HxQMbg1vPkRVgmwPpQ4S5H4LXiWNkCKFwYjNEeFr19wLSr6MaDY2vhFIBr7PCWQQEYBUwCfGhTSo9JnRjZRHCoKKdw7wKAYbEhhObtnz1vSZra4PlMGJY2HmMyPKiNoVgVetR5cVbV5qRSlJCNNBWxFklCNOrxSAQj9MlbSHjCzZHpAyXj9BizgdH4YdmQoDF2h7o9CwHRdGK4Xo4Yzj8ttbePg6h3ytgTHyolSI4uPT4CqW6vwRhqhzMcwTwMSwXZvxZwcKb625Hun4iN0rcOKKtTnpH2oGMog0Xs0LKatQ2ukK0PD6BZe6sBckDhwOOlw0dV6YDIPoS4xK0lASKFh8URKClTOoe5WhINa8euYHZeks1QibacFfo9eX5FdrZWmp6XShzVRd1i2vYlj7tds2rKJGmpqqR2TMBFMEMZtXt9oNd27Egx8Evzw54n5UkIntgfYNo2B9P9oR3GDBxdzl8qyfPz1YDgI81GA60ajfhaNcbPykSNdq6s9g63VwZyZKuCK7K75JG5L9Fsh36NTIiOwUTYF5Lc9ABrKCGaYVte02hQqCBz6E9It6ntEM7W9NskrOJnRN8yTgcEwb8sGLwnV00wwFlWwsLn3NKcl8rdw01XnFqx2qP0I34dhLWGfVEMnQ6GhKtt43oLyzblGC4RJ448b8awvVNwsaVuLfXhVO9o7NhebNCNiy7raUuD2YE56Z7MLb5Xnk1R1kUe7ueR9KnF6AHHc8l1Ymv9qgDX2PlEDfBnpWrohGWK3rZouBIEnwwS3jbNwCgfUw8I1Zri25Z09Jj7xWCxx4goXcCNnkcKpeu7FweV6JgAW0JZ0dXVA1VRojkKpaZaJmcW3uRBf6aS0g4cbYJRQ842nU0rThTwVMDyZQTLnIJ9Py8VhfnpDmSwWDLFrboNYO6nfBWXxpjBZDEPfscMHrMDlxigOvWNDvaT5S2FBkVgNnDJUii1E2y4n6EC"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueRelationType issuerelationtype = createIssueRelationType();
                java.lang.reflect.Field field = issuerelationtype.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(issuerelationtype, null);
                        validateIssueRelationType(contraints, issuerelationtype);
                        failureCount++;
                        break;
                    case 2:
                        issuerelationtype.setRelationName(contraints.getNegativeValue().toString());
                        validateIssueRelationType(contraints, issuerelationtype);
                        failureCount++;
                        break;
                    case 3:
                        issuerelationtype.setRelationDesc(contraints.getNegativeValue().toString());
                        validateIssueRelationType(contraints, issuerelationtype);
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
