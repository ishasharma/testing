package sales.app.server.service.salesboundedcontext.sales;
import sales.app.server.service.EntityTestCriteria;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.context.ContextConfiguration;
import sales.app.config.WebConfigExtended;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.TestExecutionListeners;
import sales.app.server.repository.salesboundedcontext.sales.DistributorRepository;
import sales.app.shared.salesboundedcontext.sales.Distributor;
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
import sales.app.shared.salesboundedcontext.sales.SalesRegion;
import sales.app.server.repository.salesboundedcontext.sales.SalesRegionRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class DistributorTestCase extends EntityTestCriteria {

    @Autowired
    private DistributorRepository<Distributor> distributorRepository;

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

    private Distributor createDistributor() throws SpartanPersistenceException, SpartanConstraintViolationException {
        SalesRegion salesregion = new SalesRegion();
        salesregion.setRegionname("PWGBnZ7pvbvUEGhfJ3A9gagWNWSNiBjFL1QxopRER7XJuvLkxY");
        SalesRegion SalesRegionTest = salesregionRepository.save(salesregion);
        map.put("SalesRegionPrimaryKey", salesregion._getPrimarykey());
        Distributor distributor = new Distributor();
        distributor.setRegioncode((java.lang.String) SalesRegionTest._getPrimarykey());
        distributor.setLattitude(1500.0d);
        distributor.setLongitude(5500.0d);
        distributor.setDistributorname("SqQi8fIA0CzXOvZDYNnkMWrPTzhQIXHMMaB2czrPamzdfmYcjS");
        distributor.setEntityValidator(entityValidator);
        return distributor;
    }

    @Test
    public void test1Save() {
        try {
            Distributor distributor = createDistributor();
            distributor.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            distributor.isValid();
            distributorRepository.save(distributor);
            map.put("DistributorPrimaryKey", distributor._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private SalesRegionRepository<SalesRegion> salesregionRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistributorPrimaryKey"));
            Distributor distributor = distributorRepository.findById((java.lang.String) map.get("DistributorPrimaryKey"));
            distributor.setLattitude(100.0d);
            distributor.setLongitude(2200.0d);
            distributor.setVersionId(1);
            distributor.setDistributorname("WVcLxVpx0Peulfa11trW6FFMGVQ5U2mx27UXJRYVm0HIlHrFQV");
            distributor.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            distributorRepository.update(distributor);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("DistributorPrimaryKey"));
            distributorRepository.findById((java.lang.String) map.get("DistributorPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByregioncode() {
        try {
            java.util.List<Distributor> listofregioncode = distributorRepository.findByRegioncode((java.lang.String) map.get("SalesRegionPrimaryKey"));
            if (listofregioncode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("DistributorPrimaryKey"));
            distributorRepository.delete((java.lang.String) map.get("DistributorPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateDistributor(EntityTestCriteria contraints, Distributor distributor) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            distributor.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            distributor.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            distributorRepository.save(distributor);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "distributorname", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "distributorname", "aY1qhfW0RGPLbqYNSqxf2tuhLJjgyuNTrav0Pf38b72NfDFSq5cZza84Cx0QMP5To"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "longitude", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "longitude", 1.3154305053604207E19d));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "lattitude", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "lattitude", 1.0844779534523204E19d));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                Distributor distributor = createDistributor();
                java.lang.reflect.Field field = distributor.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(distributor, null);
                        validateDistributor(contraints, distributor);
                        failureCount++;
                        break;
                    case 2:
                        distributor.setDistributorname(contraints.getNegativeValue().toString());
                        validateDistributor(contraints, distributor);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(distributor, null);
                        validateDistributor(contraints, distributor);
                        failureCount++;
                        break;
                    case 4:
                        distributor.setLongitude(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateDistributor(contraints, distributor);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(distributor, null);
                        validateDistributor(contraints, distributor);
                        failureCount++;
                        break;
                    case 6:
                        distributor.setLattitude(Double.valueOf(contraints.getNegativeValue().toString()));
                        validateDistributor(contraints, distributor);
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
