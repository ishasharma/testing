package sales.app.server.service.aaaboundedcontext.authentication;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import sales.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
public class UserAccessDomainTestCase extends EntityTestCriteria {

    @Autowired
    private UserAccessDomainRepository<UserAccessDomain> useraccessdomainRepository;

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

    private UserAccessDomain createUserAccessDomain() throws SpartanPersistenceException, SpartanConstraintViolationException {
        UserAccessDomain useraccessdomain = new UserAccessDomain();
        useraccessdomain.setDomainIcon("78UIunk8pfRPl3oWtBLLwJ7uHHt6x7ifwnzHlawIuoypGFmS5T");
        useraccessdomain.setDomainHelp("VGzPg5k6eazkmOrwZvgw016v5T5QTGH1ls88NKxABdK3IcP1Kf");
        useraccessdomain.setDomainName("K3bOuIWqseGVmEBZ4Qb21KsPnYK6BRY3tB9DBKO6hNKgEbz3BV");
        useraccessdomain.setDomainDescription("fmgv4cjrX4qNH2OCrnkn0PrjJoEXVfd5OMhcyzKKOymAZW0r31");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setEntityValidator(entityValidator);
        return useraccessdomain;
    }

    @Test
    public void test1Save() {
        try {
            UserAccessDomain useraccessdomain = createUserAccessDomain();
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            useraccessdomain.isValid();
            useraccessdomainRepository.save(useraccessdomain);
            map.put("UserAccessDomainPrimaryKey", useraccessdomain._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            UserAccessDomain useraccessdomain = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
            useraccessdomain.setDomainIcon("hG4Oko2bn0p3bFTZTOJuERsN3hr974ZpK3iOY8txDPEQNv0z2i");
            useraccessdomain.setDomainHelp("w9Byaq5aKK1yoxNPzZfvix9NM5rwE4F17fln5HJ58MZzioHjzb");
            useraccessdomain.setDomainName("JNlxop1hYsq0ROtJXlRDtzutPfIvaQeejBWgTqppyKwbS9EDvs");
            useraccessdomain.setDomainDescription("dMM7pfBHUKGpCpYgc16pg6xyXVrvwRjdcB2qBHHfzeMHxruSPu");
            useraccessdomain.setUserAccessDomain(61433);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            useraccessdomainRepository.update(useraccessdomain);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("UserAccessDomainPrimaryKey"));
            useraccessdomainRepository.delete((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateUserAccessDomain(EntityTestCriteria contraints, UserAccessDomain useraccessdomain) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            useraccessdomain.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            useraccessdomainRepository.save(useraccessdomain);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "userAccessDomain", null));
        entityContraints.add(new EntityTestCriteria(UNIQUE, 2, "userAccessDomain", ""));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessDomain", 188784));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "domainName", "5lhcq3d5Z0bUCqBpmCNPbdwxTn74NOg4X9CBwuYgmPEOyP74J4Q0sJBOUu0oxMAVRU5XwVPXLg1IJdWSh14ymQfoKLbG2JAG8ZQazHVAFQZiQQXglw5n9XLjplQTrvjeztFmQ5gNeYJGyPfxSZRiIquhcHDpJjFlQ5Yv2x8f55kFSN3h7yglqLdn63rmFfdfmYbcQbZEFfTaYo8LsIxNnKbSfeV4BHOlyyTDYMKhi4qTDIEEeAKtaL1gfgZ4JPtYc"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainDescription", "4m4ItWtHtAWa3emYBvauP7Kr0CvpFRy7CaMgWPofLvgL5PhwaAbGfA2b8SHyz36GRsLevRTLWddrIuWXakTIZrvPJxCz3Z0j7m9R0kquWojzww2Mq7Ys8y4HvGr5hMd15L1DkbwY6bhGTfD16GswjK3QWxm695GTOZ0WJZZ55WmCJ4yLO6zHQ7fpp0N8JM9ZdW556MoEUbcbFCLbRSPjSNA3sD3LwVzG1kr4J2Y4RAXJnwhBRFuY1wg4xk71ClGtT"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "domainIcon", "6JdcFffAZgDQOV59p1ehKWBtg9cAOH3GJMIU6YmF9VaMq2Yv649nZegAqQ2KAi1CD88X58pwshK0vAHhnFqHkPKa3ea05grRJARe7S0GQeACl8R5LIt0pcdzRdUKCXPvbqlx1FAHTgACecTil61JaYjDEplbBKmmN88ZhZGJoriuNWzckf8nOiF65U3hY9RnXkgz17rDOiGWz35Ev19hUA5eRZ8JcOzy485AIi89XDkHSCevIt6J8cA6OZiwKUCJP"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                UserAccessDomain useraccessdomain = createUserAccessDomain();
                java.lang.reflect.Field field = useraccessdomain.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 2:
                        UserAccessDomain useraccessdomainUnique = useraccessdomainRepository.findById((java.lang.String) map.get("UserAccessDomainPrimaryKey"));
                        useraccessdomain.setUserAccessDomain(useraccessdomainUnique.getUserAccessDomain());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 3:
                        useraccessdomain.setUserAccessDomain(Integer.parseInt(contraints.getNegativeValue().toString()));
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 4:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 5:
                        useraccessdomain.setDomainName(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 6:
                        field.setAccessible(true);
                        field.set(useraccessdomain, null);
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 7:
                        useraccessdomain.setDomainDescription(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 8:
                        useraccessdomain.setDomainHelp(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
                        failureCount++;
                        break;
                    case 9:
                        useraccessdomain.setDomainIcon(contraints.getNegativeValue().toString());
                        validateUserAccessDomain(contraints, useraccessdomain);
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
