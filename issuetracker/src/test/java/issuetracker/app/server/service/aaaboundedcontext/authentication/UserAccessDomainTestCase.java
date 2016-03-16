package issuetracker.app.server.service.aaaboundedcontext.authentication;
import issuetracker.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import issuetracker.app.config.WebConfigExtended;
import org.springframework.test.context.ContextConfiguration;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import issuetracker.app.server.repository.aaaboundedcontext.authentication.UserAccessDomainRepository;
import issuetracker.app.shared.aaaboundedcontext.authentication.UserAccessDomain;
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
        useraccessdomain.setDomainIcon("mk4Etge7NvPWQrryvYSOTCAaxq6xmvPcByn5styELocQgz7ORn");
        useraccessdomain.setUserAccessDomain(valueGenerator.getRandomInteger(99999, 0));
        useraccessdomain.setDomainHelp("qxRCbBdcxmAChPEj1u24t94EfJFeTNOchW5VvCX7EHtVfzf5nG");
        useraccessdomain.setDomainName("NkkAHvH9HsFCI1trhpXbJGjxmMQHfnZyCnbTZAX9nSOsY5YEWQ");
        useraccessdomain.setDomainDescription("CINk6OwBBWe6OYcVqK8LBs6jIi6sXpIsoC2ljhBOmpF6bZUtAs");
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
            useraccessdomain.setDomainIcon("LXcpPN18JttYuctneSPnYa8X65QSpxuwmos0bvWCC2CNWePeUh");
            useraccessdomain.setUserAccessDomain(56448);
            useraccessdomain.setVersionId(1);
            useraccessdomain.setDomainHelp("bqefd4NcDndEOoaqkhgtfe9NUaPRbzBfJLUxhyMPjJALIifwHp");
            useraccessdomain.setDomainName("oeFLcrLlaS8o3SrZcJjMr1jXpcbO2Qpo6GGPFKpt0AmdHpvdiG");
            useraccessdomain.setDomainDescription("HOQP7m1vbSphYUQgWeWS2sYovoYtXfxw2BX7yw1dVbyP1LUz8j");
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
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 3, "userAccessDomain", 198812));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 4, "domainName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 5, "domainName", "HolClIcgscjubMp3cS4ktYFrvGVtvNzmkl9Mwtw4ddinyMymxJlo6AhgUEkIHY7P6fb1MTVup9juUfbRTt3fEjKjd2p6JECTs6OBwKxm07g4J1WGNDqMcrux8KaM8Jr6mxdtdugyaOLAE3yvlSgbymw7RxmjhQ4QLixAYKLQPWC2fMzy0tgIl3BhQwu6wrPqzlYVg2zpqwxPKaYd2yl9kGX8IsKwXaTarv1BUqmvQHqeuJOvUs04KnWVBNxT3V34P"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 6, "domainDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "domainDescription", "UNYyS63nuMT9Acly8hBumac2a7Np3NcC3u8X6eZgYtjSWxnhp6M99YVVOAMSwNfmoUOfzkjRGm3LrmtXkA9EpTIbi3OdAqfvEHV4RYUPDKTpGrjcFokssjLannYjJZKha50dCVV6Bz2Wlqhwz69a2k7j2vjttaPocO02GuL3jyNbxIwlTMxc9Y0FOftlJ7A4Pdb7tRnMuc5R8sy1ChvxjSvuzHBVgk93sAgpH2CHkBLNzg3UvmtDm503EAhuuSfds"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "domainHelp", "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"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "domainIcon", "zx7ceSl4mEfb4N3NNwIZ9KlN2BOXrYqYn4JxyhUKoAbznoJaLYShrS3zwvWdXOVrlNbXTOHybXoAZ2pSBBubKhMqRGaUzXGXlNYBtBRj6uohwzs6ij8TOx0c9N8aHnlWOTZuykUCO7OIIkx7Iodcju2Mtd7LR7bJr1QMqE9xamUtt923UPNoE65WoDzAh7NuVi4ZorQds4ScBbQeXukwxssbMwcfIAOSW8daD0A26wqYPGW0GRGHQhmkqxocd8s0l"));
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
