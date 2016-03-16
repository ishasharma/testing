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
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueHistoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueHistory;
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
import issuetracker.app.shared.organizationboundedcontext.contacts.CoreContacts;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CoreContactsRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Timezone;
import issuetracker.app.server.repository.organizationboundedcontext.location.TimezoneRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Title;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.TitleRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.Gender;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.GenderRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Language;
import issuetracker.app.server.repository.organizationboundedcontext.location.LanguageRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Address;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressRepository;
import issuetracker.app.shared.organizationboundedcontext.location.Country;
import issuetracker.app.server.repository.organizationboundedcontext.location.CountryRepository;
import issuetracker.app.shared.organizationboundedcontext.location.City;
import issuetracker.app.server.repository.organizationboundedcontext.location.CityRepository;
import issuetracker.app.shared.organizationboundedcontext.location.State;
import issuetracker.app.server.repository.organizationboundedcontext.location.StateRepository;
import issuetracker.app.shared.organizationboundedcontext.location.AddressType;
import issuetracker.app.server.repository.organizationboundedcontext.location.AddressTypeRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationData;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationGroup;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationGroupRepository;
import issuetracker.app.shared.organizationboundedcontext.contacts.CommunicationType;
import issuetracker.app.server.repository.organizationboundedcontext.contacts.CommunicationTypeRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStage;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStageRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssuePriority;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssuePriorityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueSeverity;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueSeverityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueStatus;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueStatusRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueCategory;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueCategoryRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueFlag;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueFlagRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueActivity;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueActivityRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueWorkflow;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.IssueWorkflowRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectFeature;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectFeatureRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectModule;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectModuleRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ModuleUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.FeatureUserMapping;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.AddWatchers;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueAssignment;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.IssueHeaders;
import issuetracker.app.shared.issuetrackerboundedcontext.issuetracker.FeatureCategory;
import issuetracker.app.server.repository.issuetrackerboundedcontext.issuetracker.FeatureCategoryRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class IssueHistoryTestCase extends EntityTestCriteria {

    @Autowired
    private IssueHistoryRepository<IssueHistory> issuehistoryRepository;

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

    private IssueHistory createIssueHistory() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("6TIixmEeDAL2Dl5zncJvazYZA8lhj9OgOYl6JrITFTNjvd11RB");
        corecontacts.setMiddleName("nXYoVZ8KvNduMNV2iwXzd0qmLhxjyx9jxcM2qVbLXCMYHgqNnk");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("Yy3KTgOajhto3iKsoN5Itqao4L3SmuwuLMULrbxzLXDWiynpFB");
        timezone.setTimeZoneLabel("ir2giPyWtWQKLmWb1XL1EOSuQ7cKwGL5BeHYDX3ShUPVUFpdab");
        timezone.setCountry("qviM4ndqbP6TZrr0od7CVSvYiHQXc4fXkhcSRwtAse4YmLmgcy");
        timezone.setCities("3lgHTgcFOvYneADpp7VFcxtp7YckQGjbQ4IzVNxQohF8pTDwnM");
        timezone.setUtcdifference(9);
        Title title = new Title();
        title.setTitles("hnHJly4d5JDJJ6I5n1YYZKMz9zEib2Z4IJz6v21p4U4aevEzp0");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("mELRpG6XCLxGLqlxsqFmi2HgWnIWu7HsgU7SVP6DKBsdEjlP41");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("J6BPHbaIeLc9wgdKXzJQ5kECRaIEi3eeGeumqmg1pxJ4FX8t3v");
        language.setAlpha4parentid(9);
        language.setAlpha2("Yn");
        language.setLanguageIcon("iLxF7iC1PdNLOvpXs2bzz8z6JvlIZF94WOhYSdQqk1BVvADihK");
        language.setAlpha4("4rUG");
        language.setAlpha3("TRF");
        language.setLanguageType("f1ejKG9WALe1dUZ8Nws4zSER6Hme72RO");
        language.setLanguageDescription("KZOiI3HNyehW7DgZIwd3WKz9dvpNOVOmuZ7UpaqecuDe6yPuhv");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("8q0QYxE6bv4OeuHyBPkHYSM2LvLyTfkU4XkiNbPjO6VyXuuNKW");
        corecontacts.setMiddleName("gq3R5Pv6LgDyEwIx8VOQ7UdG2sAqYbqmB09qsHRuuAtzZufiOu");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("kp4kfqQQmhEbJSYQXIRNsCuMwoFqM5gMwDZvMznEuUWE3GON1m");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127890788l));
        corecontacts.setAge(53);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("g5XlYvDuMOp57b3wcgMlTLgKoqzso47RufLUEk0tP5BhvvxWyj");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("xGpUaEKRaWuKHwg8GZlARXF6FSGa4m4DD15kfgFnqNz9nTzjeH");
        corecontacts.setPhoneNumber("QjIj376e3IQhn7sKByfb");
        corecontacts.setEmailId("YEPa7iqIV5xOwt0jsnJwZdnoVHdnT4YaynWbR67cSokTbrpQYF");
        corecontacts.setNativeMiddleName("HkH8aqBlV3T10HMql4fqtUxIYYmhDlxK3acpRqCe5Ear3v82r8");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127890905l));
        corecontacts.setNativeTitle("bJE4jziDtBg8xw09UybnMVocmsn1BiIfONDjoPsQYRIgzcQzNG");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("AClWJnDZGl1O47JkmTO9Xf6IB6iFxYdERocMphhmIGznsU0ARI");
        country.setCountryCode1("y4N");
        country.setCapitalLongitude(11);
        country.setCurrencyName("T4XleyXCLPINnsgiJcqbdWESxX5UIX05mMhCbBz4AS9eM1Lr74");
        country.setCurrencyCode("f9R");
        country.setCountryFlag("A6mixuHA0qWP206hrgCEqOAuNXUFhxK3CxxyW84jhOFFse1NKC");
        country.setIsoNumeric(9);
        country.setCapitalLatitude(2);
        country.setCapital("AuKeNNp7iVxKS4Yeym9pfe679pj7fn8g");
        country.setCountryCode2("pC0");
        country.setCurrencySymbol("BXIqMLtqaVhUAdsF3qQg2faSAIWEtQGA");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("PhOAPdfozznDMtKDRgTUjroXNCvL9mfvBYczGrY3Hqkmcv00hA");
        city.setCityLongitude(6);
        city.setCityLatitude(1);
        city.setCityDescription("qMdGXkn9dOnJibBcvKZtfH2jcOfZEuwIVMXmwOtszB6y2rEZcr");
        city.setCityCode(1);
        city.setCityName("1GXkdcRgo7fEpCYkJZ0FNDNV52OyhxAN5g0IopmgVHm6XaLWyX");
        State state = new State();
        state.setStateCodeChar2("HzvYWcxoR6YKbd5R09aHv1lml1sLv4C4");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar3("cgWq3i2DZ8khwe8iUprk32LkAGUuIZoc");
        state.setStateCodeChar2("GimC5Ujx5ZNAVjXk7h0Ik7X0qDlip1h0");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar3("ZEA2LGrFlRAY8UTyWpi3esE39ScWzGfo");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("BKEO9JY38LFH1W21ZJ0yr9W17KulxiCIZUrjsueIqMNPisz9IU");
        state.setStateFlag("uL313LPUFoSbc1ZvIiY7TEUGJ3h8GxVNTHX0sHEWweBgg3syXo");
        state.setStateCapital("kgKB6hjdzq7LyAMYVSDQAB0mkudfJ2xEniK1vGyYVtgsI5rjl2");
        state.setStateCapitalLatitude(2);
        state.setStateDescription("o0eEB3MBRTJ35uBhyCymxzH9h6X3Jt7pRzDP6M9Zi6zBdCwxua");
        state.setStateCode(1);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("PmhhLMZBZ0jCnhs92gftQ8eM5kernGcgUJTQz33PgSSm7hjsoP");
        city.setCityLongitude(8);
        city.setCityLatitude(6);
        city.setCityDescription("Oyu2zhrNdSpUjK8MJc1LkST5BjC1XisuTNuuDilS9fvk8QV6mZ");
        city.setCityCode(2);
        city.setCityName("Iky9J6gFngBcAHjiUG35De40PCEnQ2CeJUIDrmHb1fJqMLerOq");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("PqAL829uFh23HQsDDdd80BvOIqDCiDvE");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("9gSzkwAUUp39F1lNkxYBzZsUJxgNphYZlyaUR3JGWIo1oa7wK0");
        addresstype.setAddressTypeDesc("oNwNfRIy18AS0HZ2s0GFnmHaUhQP680k0aRd4ttm1QIwgsgTPk");
        addresstype.setAddressType("oYhyupS4gO2xCJWrwOlfzJ754d9Ab2RtAsBC5eNRBurHPdkwFb");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("j211kcE6qdOjNwuAeVY6KA8rmhLtQoPlq0U6wD4lqFQASQ9G0U");
        address.setAddress1("b0CeeoQEQR0NrvZAW530nU9lKpUfZV2PxuQgIkgimopFpxcfGF");
        address.setLatitude("BE1xV0mzRH4eCsHE24GR850ut1evl7K3vaC8yCF7GhULyqOGj5");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("qaFiDa");
        address.setAddress2("lKsxDVHAKaf8QANHYdDXmkdgUkyCreZ80q95vkkEQMmCCnZjDD");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("pvWNLLf3p5I");
        address.setAddress3("kYG7ZoufcOtymzwuZShjXIqIkC0jnBQxq3EbtDhM6jfuZawCLC");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("7Izrm7gRTVG7KdKdl0t0OvJKbPGii7Msw54iQByLdzftV95HLm");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("VqZK0Sj0m2vtUj6pC19BUmGfd6PrmTZHOiIeRSB814YSrzPp3W");
        communicationgroup.setCommGroupName("5U68vszdr4Tn8d1n1drGjtulzrXNU14vfARI2oC7W5XAQvXsio");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("B55SrQeP4TDjhib3DK50oxbGFikAhxsGucrpiYLrqtoMjY5B1A");
        communicationtype.setCommTypeName("MqqGRgvZeQxPiAtaa6I3jlqhEPDxPTZAsKjTG9dpGlVR2TwCCU");
        communicationtype.setCommTypeDescription("tyjKGeSVs3KIHzErdz92CFtH5v9PSucVgMrJE4aYRJJekyaN43");
        communicationtype.setCommTypeName("18YLrp3O5dx1InNyVEdJElIKHMdhmWih0RHlICccEgelysc3xc");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("f84gZP0lfsD8kpbvBPUdC9RImncgcxNZrfBekolqkr3majpMYc");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        IssueStage issuestage = new IssueStage();
        issuestage.setIssueStageName("tVXkvin9lzPxT4gvlddVj12MnEF3ZlLa5CWk0ztHFKNgvfkOEk");
        issuestage.setIssueStageId("x0I3BRzO4mSvviibxfySRNvXy1iwjsZye1c45wlRpH3DcrzqmP");
        issuestage.setIssueStageDesc("MPlkvwftY3ld8QG8OHMLS6Y3FjzQmdprqwUraoNAFjpRvfoo0O");
        IssueStage IssueStageTest = issuestageRepository.save(issuestage);
        map.put("IssueStagePrimaryKey", issuestage._getPrimarykey());
        IssuePriority issuepriority = new IssuePriority();
        issuepriority.setIssuePriorityDesc("XgAzY9IsaGTfru4wcDl6sibN3Sd32UIIm0qypnd4VZWFE5d9OM");
        issuepriority.setIssuePriorityName("nY16NL2uTcyXg4LvivIq4GS647ocV4HQsmbSAURrx8rXtfhpyy");
        IssuePriority IssuePriorityTest = issuepriorityRepository.save(issuepriority);
        map.put("IssuePriorityPrimaryKey", issuepriority._getPrimarykey());
        IssueSeverity issueseverity = new IssueSeverity();
        issueseverity.setIssueSeverityName("lV8wYZSzDHXbppITUdypzNUHAFdw3auKzlplZGn9H7fxrzD7XX");
        issueseverity.setIssueSeverityDesc("5t9tJmTFGIeEOLoLV4QlkwQPtGykuo5dSeLSKXRMbf6bwct4Nz");
        IssueSeverity IssueSeverityTest = issueseverityRepository.save(issueseverity);
        map.put("IssueSeverityPrimaryKey", issueseverity._getPrimarykey());
        IssueStatus issuestatus = new IssueStatus();
        issuestatus.setIssueStatusDesc("uR6Dg6WgZU7WcpEU3SwKR4qEnrQvWLqluEMXdLdKMtuSAz5XQg");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("vwbBq4chQvvpHrbIiCHK0R2KqM9fd4EW5jqXkh2n6LOGa0MTns");
        issuestatus.setIssueStatusDesc("kgAbfbWcbPLHgC7vOQIHqZkqBTXTY5U7skirYmS98A2sUgFBZX");
        issuestatus.setIssueStatusId(valueGenerator.randomValueGenerate("String", 64, 0));
        issuestatus.setIssueStatusName("tjlRqcCZXw6RqijZAGFCGbEmRYzRw1rccljHjRPE9V1QKezqiD");
        issuestatus.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        IssueStatus IssueStatusTest = issuestatusRepository.save(issuestatus);
        map.put("IssueStatusPrimaryKey", issuestatus._getPrimarykey());
        IssueCategory issuecategory = new IssueCategory();
        issuecategory.setIssueCategoryName("DI9r18Ws7jZF6IbfYQ3esLDlM4Tu1Tf01w1rhL35ni6YX0ynvq");
        issuecategory.setIssueCategoryDesc("UVsixVcEG6DDqIehTLPuXgyQd0GtIDFrFILqFmJvGmofL0e7i5");
        IssueCategory IssueCategoryTest = issuecategoryRepository.save(issuecategory);
        map.put("IssueCategoryPrimaryKey", issuecategory._getPrimarykey());
        IssueFlag issueflag = new IssueFlag();
        issueflag.setIssueFlagDesc("UidD9L0Xqhjv3BNAU5ldi9gatav0NEFTQzzcjkKckvQlL2APlr");
        issueflag.setIssueFlagName("3uPBm4yZzpuDBgAIROHjZhApkj8CeZ27otbAJRqqdmIA7zyAh1");
        IssueFlag IssueFlagTest = issueflagRepository.save(issueflag);
        map.put("IssueFlagPrimaryKey", issueflag._getPrimarykey());
        IssueActivity issueactivity = new IssueActivity();
        issueactivity.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueactivity.setIssueActivityDesc("QA300VjXTtJA4p798gTwweHoJmwcp2H537oxgBUDBKmzzoD0VB");
        issueactivity.setIssueActivityName("o0iVGjVKBwNj7iHGEyXMfbGNgyWeyQfVbJ0HxJxwnC9FG92vH0");
        issueactivity.setIssueActivityId(valueGenerator.randomValueGenerate("String", 64, 0));
        IssueActivity IssueActivityTest = issueactivityRepository.save(issueactivity);
        map.put("IssueActivityPrimaryKey", issueactivity._getPrimarykey());
        IssueWorkflow issueworkflow = new IssueWorkflow();
        ProjectFeature projectfeature = new ProjectFeature();
        ProjectModule projectmodule = new ProjectModule();
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        CreateProject createproject = new CreateProject();
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("Gfn2KHCkfTAZyQlviCxU5NEeNN4OAxeYtahpuOaopa4H9ZkgXI");
        projectaccessrights.setProjectAccessDesc("HiVa3tSjLm0PxrgA3iLT9rgs0HMAs7dNjEFbk4tJ51NlEqh7ni");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("9nwKbLFH7n5d1RRsRBQOLqSSG9OodNxJyEIXrokZzd0qxdpRNN");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("ymSUUyZFaGQLOngxuhdEDyoy4bNVebP6keFdVtLDqjnPg44tOH");
        createproject.setVersion("wEoQkyu5w30qMNSFRL7rUCsT5XtQOlZvMLfbKu0gV9rxImb2zP");
        createproject.setProjectName("RaUS3e9dhUR4AqeHtm6TeDzl6iGQENWN6x50Ith5LMnQdX2PbB");
        createproject.setProjectDescription("RdFNlkUVwI8F3wNpKhr5MS0mJo83W1VO1YZgMKNV93NVVi7pfA");
        createproject.setProjectURL("Yfl0wbjGcmffB7QqzBjrV0rOTuWxzbzvYwfB0JxW8XfHCJGV8r");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        CreateProject CreateProjectTest = createprojectRepository.save(createproject);
        map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        projectmodule.setDateOfCreation(new java.sql.Date(123456789));
        projectmodule.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectmodule.setModuleShortName("wnRiVVhg7g9b8LW8Vb2ky8BDqmtDbRc8CYxi8JyCq9Q3MufOwT");
        projectmodule.setModuleName("UpkKTqz4mIr3OXVi9OYtytIA85iEtLoF7aaZaFvPxkwRuZS6ZO");
        projectmodule.setVersion("XO59RF3kybs33mpHQjxqJbonwYLJzM5IFT8rQKAvPvOutdLh0z");
        projectmodule.setBuild("vGiMuxu4tVp2iK256fzJfanLJPO6TSQOqEBPInWzpMASvo6Ysu");
        projectmodule.setModuleDescription("FYhjST7sp7tgq7otzmaiVDUpHCViHNcHMU7eYwxdhzeZdLwait");
        java.util.List<ModuleUserMapping> listOfModuleUserMapping = new java.util.ArrayList<ModuleUserMapping>();
        ModuleUserMapping moduleusermapping = new ModuleUserMapping();
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setIsAdmin(true);
        moduleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        moduleusermapping.setProjectModule(projectmodule);
        moduleusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfModuleUserMapping.add(moduleusermapping);
        projectmodule.addAllModuleUserMapping(listOfModuleUserMapping);
        ProjectModule ProjectModuleTest = projectmoduleRepository.save(projectmodule);
        map.put("ProjectModulePrimaryKey", projectmodule._getPrimarykey());
        projectfeature.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectfeature.setVersion(11);
        projectfeature.setBuild(10);
        projectfeature.setFeatureShortName("qJxocUexRpiBSBXpItQl7QXI5MXmBJdw9ai2y0eLLCaHXpdjpb");
        projectfeature.setDateOfCreation(new java.sql.Date(123456789));
        projectfeature.setFeatureDescription("23MNAyU8N7FEUtrtNISLk4F0tQk1RBJShVH6z7LCbnd6eickEn");
        projectfeature.setFeatureName("84lqUiASLaKyt6m3iBir38bdikDZ2LKztz8lU70kaelM2ATcJs");
        projectfeature.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        java.util.List<FeatureUserMapping> listOfFeatureUserMapping = new java.util.ArrayList<FeatureUserMapping>();
        FeatureUserMapping featureusermapping = new FeatureUserMapping();
        featureusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setProjectFeature(projectfeature);
        featureusermapping.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        featureusermapping.setIsAdmin(true);
        listOfFeatureUserMapping.add(featureusermapping);
        projectfeature.addAllFeatureUserMapping(listOfFeatureUserMapping);
        ProjectFeature ProjectFeatureTest = projectfeatureRepository.save(projectfeature);
        map.put("ProjectFeaturePrimaryKey", projectfeature._getPrimarykey());
        issueworkflow.setCreatorContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setDateCreated(new java.sql.Date(123456789));
        issueworkflow.setoS("q8rgByX10v6BRI6R68wXCM2JR1Hnng0IMQBaUQn7rInm4XUOm4");
        issueworkflow.setStepsToReproduce("rwjh7Tzkq3aCt6mUpfSXvGJDMeLycxJW130RgiRHvpq7AMSGb2");
        issueworkflow.setFeatureId((java.lang.String) ProjectFeatureTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setModuleId((java.lang.String) ProjectModuleTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setIssueDescription("moYIqEMHuxJj406YyW3iHZNS1W7a3pvdcfzOSqBa1m9vuXobI5");
        issueworkflow.setProjectId((java.lang.String) CreateProjectTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueworkflow.setBrowser("wwOdM3jozojkD6XMjD0yOPhUyous51w03IFDfb0ceB5wBLDTDK");
        issueworkflow.setIssueTitle("jpclaE9YwYdXZHM84ZhEs3czR7om8AxMbGr5lzlBIsmeZ2zs1o");
        java.util.List<AddWatchers> listOfAddWatchers = new java.util.ArrayList<AddWatchers>();
        AddWatchers addwatchers = new AddWatchers();
        addwatchers.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        addwatchers.setIssueWorkflow(issueworkflow);
        listOfAddWatchers.add(addwatchers);
        issueworkflow.addAllAddWatchers(listOfAddWatchers);
        IssueAssignment issueassignment = new IssueAssignment();
        issueassignment.setStartTime(new java.sql.Date(123456789));
        issueassignment.setStartTime(new java.sql.Date(123456789));
        issueassignment.setIssueWorkflow(issueworkflow);
        issueassignment.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueassignment.setEndTime(new java.sql.Date(123456789));
        issueassignment.setIssueDate(new java.sql.Date(123456789));
        issueassignment.setComments("p8VLa2NGfkBzpl7KgF1RHTS2YY3csR0CjZ63unLXcKktDV0nam");
        issueworkflow.setIssueAssignment(issueassignment);
        IssueHeaders issueheaders = new IssueHeaders();
        FeatureCategory featurecategory = new FeatureCategory();
        featurecategory.setFeatureCategoryName("RNg1QXRBONR9V4BMvkwqSSVOdiP6I4PzMRhsRlyMDxwBAfDSKx");
        featurecategory.setFeatureCategoryDesc("d9TqvDOg2Wjw5mLREvsotzyWw3rBLmD9rXk5vHpvaiJuJm34BA");
        FeatureCategory FeatureCategoryTest = featurecategoryRepository.save(featurecategory);
        map.put("FeatureCategoryPrimaryKey", featurecategory._getPrimarykey());
        issueheaders.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setEffortEstimate(new java.sql.Date(123456789));
        issueheaders.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueWorkflow(issueworkflow);
        issueheaders.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issueheaders.setComments("r2RKS6Iv8J7Iv8gySI3DXX2U6DeGpQFfpH7Tg5J1H8kxsjzCsd");
        issueheaders.setLastUpdated(new java.sql.Date(123456789));
        issueworkflow.setIssueHeaders(issueheaders);
        IssueWorkflow IssueWorkflowTest = issueworkflowRepository.save(issueworkflow);
        map.put("IssueWorkflowPrimaryKey", issueworkflow._getPrimarykey());
        IssueHistory issuehistory = new IssueHistory();
        issuehistory.setEffortEstimate(new java.sql.Date(123456789));
        issuehistory.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueStageCode((java.lang.String) IssueStageTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setComments("uum5ooYDelxyBJXIpHG4QK8KcIJAu570JnhcZ8bLFhTDzVRtlq");
        issuehistory.setIssuePriorityCode((java.lang.String) IssuePriorityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setLastUpdated(new java.sql.Date(123456789));
        issuehistory.setIssueSeverityCode((java.lang.String) IssueSeverityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueStatusCode((java.lang.String) IssueStatusTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setEndTime(new java.sql.Date(123456789));
        issuehistory.setIssueDate(new java.sql.Date(123456789));
        issuehistory.setIssueCategoryCode((java.lang.String) IssueCategoryTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueFlagCode((java.lang.String) IssueFlagTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueActivityCode((java.lang.String) IssueActivityTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setIssueId((java.lang.String) IssueWorkflowTest._getPrimarykey()); /* ******Adding refrenced table data */
        issuehistory.setStartTime(new java.sql.Date(123456789));
        issuehistory.setFeatureCategoryCode((java.lang.String) FeatureCategoryTest._getPrimarykey());
        issuehistory.setEntityValidator(entityValidator);
        return issuehistory;
    }

    @Test
    public void test1Save() {
        try {
            IssueHistory issuehistory = createIssueHistory();
            issuehistory.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            issuehistory.isValid();
            issuehistoryRepository.save(issuehistory);
            map.put("IssueHistoryPrimaryKey", issuehistory._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private CoreContactsRepository<CoreContacts> corecontactsRepository;

    @Autowired
    private TimezoneRepository<Timezone> timezoneRepository;

    @Autowired
    private TitleRepository<Title> titleRepository;

    @Autowired
    private GenderRepository<Gender> genderRepository;

    @Autowired
    private LanguageRepository<Language> languageRepository;

    @Autowired
    private AddressRepository<Address> addressRepository;

    @Autowired
    private CountryRepository<Country> countryRepository;

    @Autowired
    private CityRepository<City> cityRepository;

    @Autowired
    private StateRepository<State> stateRepository;

    @Autowired
    private AddressTypeRepository<AddressType> addresstypeRepository;

    @Autowired
    private CommunicationGroupRepository<CommunicationGroup> communicationgroupRepository;

    @Autowired
    private CommunicationTypeRepository<CommunicationType> communicationtypeRepository;

    @Autowired
    private IssueStageRepository<IssueStage> issuestageRepository;

    @Autowired
    private IssuePriorityRepository<IssuePriority> issuepriorityRepository;

    @Autowired
    private IssueSeverityRepository<IssueSeverity> issueseverityRepository;

    @Autowired
    private IssueStatusRepository<IssueStatus> issuestatusRepository;

    @Autowired
    private IssueCategoryRepository<IssueCategory> issuecategoryRepository;

    @Autowired
    private IssueFlagRepository<IssueFlag> issueflagRepository;

    @Autowired
    private IssueActivityRepository<IssueActivity> issueactivityRepository;

    @Autowired
    private IssueWorkflowRepository<IssueWorkflow> issueworkflowRepository;

    @Autowired
    private ProjectFeatureRepository<ProjectFeature> projectfeatureRepository;

    @Autowired
    private ProjectModuleRepository<ProjectModule> projectmoduleRepository;

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

    @Autowired
    private FeatureCategoryRepository<FeatureCategory> featurecategoryRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            IssueHistory issuehistory = issuehistoryRepository.findById((java.lang.String) map.get("IssueHistoryPrimaryKey"));
            issuehistory.setEffortEstimate(new java.sql.Date(123456789));
            issuehistory.setComments("sawjceRfY2yPDCrqXaxrKXsdbYkQVukXBV6tev3vg5AHB0Hjil");
            issuehistory.setVersionId(1);
            issuehistory.setLastUpdated(new java.sql.Date(123456789));
            issuehistory.setEndTime(new java.sql.Date(123456789));
            issuehistory.setIssueDate(new java.sql.Date(123456789));
            issuehistory.setStartTime(new java.sql.Date(123456789));
            issuehistory.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            issuehistoryRepository.update(issuehistory);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<IssueHistory> listofcontactId = issuehistoryRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
            if (listofcontactId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStageCode() {
        try {
            java.util.List<IssueHistory> listofissueStageCode = issuehistoryRepository.findByIssueStageCode((java.lang.String) map.get("IssueStagePrimaryKey"));
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
    public void test3FindById() {
        try {
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            issuehistoryRepository.findById((java.lang.String) map.get("IssueHistoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissuePriorityCode() {
        try {
            java.util.List<IssueHistory> listofissuePriorityCode = issuehistoryRepository.findByIssuePriorityCode((java.lang.String) map.get("IssuePriorityPrimaryKey"));
            if (listofissuePriorityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueSeverityCode() {
        try {
            java.util.List<IssueHistory> listofissueSeverityCode = issuehistoryRepository.findByIssueSeverityCode((java.lang.String) map.get("IssueSeverityPrimaryKey"));
            if (listofissueSeverityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueStatusCode() {
        try {
            java.util.List<IssueHistory> listofissueStatusCode = issuehistoryRepository.findByIssueStatusCode((java.lang.String) map.get("IssueStatusPrimaryKey"));
            if (listofissueStatusCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueCategoryCode() {
        try {
            java.util.List<IssueHistory> listofissueCategoryCode = issuehistoryRepository.findByIssueCategoryCode((java.lang.String) map.get("IssueCategoryPrimaryKey"));
            if (listofissueCategoryCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueFlagCode() {
        try {
            java.util.List<IssueHistory> listofissueFlagCode = issuehistoryRepository.findByIssueFlagCode((java.lang.String) map.get("IssueFlagPrimaryKey"));
            if (listofissueFlagCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueActivityCode() {
        try {
            java.util.List<IssueHistory> listofissueActivityCode = issuehistoryRepository.findByIssueActivityCode((java.lang.String) map.get("IssueActivityPrimaryKey"));
            if (listofissueActivityCode.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByissueId() {
        try {
            java.util.List<IssueHistory> listofissueId = issuehistoryRepository.findByIssueId((java.lang.String) map.get("IssueWorkflowPrimaryKey"));
            if (listofissueId.size() == 0) {
                org.junit.Assert.fail("Query did not return any records.");
            }
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByfeatureCategoryCode() {
        try {
            java.util.List<IssueHistory> listoffeatureCategoryCode = issuehistoryRepository.findByFeatureCategoryCode((java.lang.String) map.get("FeatureCategoryPrimaryKey"));
            if (listoffeatureCategoryCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("IssueHistoryPrimaryKey"));
            issuehistoryRepository.delete((java.lang.String) map.get("IssueHistoryPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateIssueHistory(EntityTestCriteria contraints, IssueHistory issuehistory) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            issuehistory.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            issuehistory.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            issuehistoryRepository.save(issuehistory);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 1, "comments", "kHosnDg1wbMUx7clADTT0eNmMIFlMtKEktVLkMtPFa8C3ZvQbZOFDFHFiwGxsBxTUR6KOlPvEaE0Kgja1xzTlD0FDX4TdIjmJELbnwh8w13pMDfKfu8dENHtLgPJd3s5q84IYDkaouF9WZLXrvS4FYfD3nmrQAM0wrI9H8kD5qikmReQhGj6M2CkFGs71Ekz2Nr9jNVVycxzPJbmoMNJNqW7TCjY8oZ2tO6YMzcRQz0g3OoNjMxfOFiPqbblZ7aPmySNO4kfBVZZeCNrn8C2hZfuXyfvOqjRJJU8JzjHer5zuNThrZStY7K75MP46DECLMJH5nfKJDlSKpHvmItrLBTbtJUydflog9cXcPljXvVY0CXfPnHm0L6osRmt1LLy5QLCsnGTEY1OtHlNRiDadtinZdlCGOxZYFWOV0B0lqYSvgkHpuIfOTsEkdma254RKstrvKsRfI4KOAlJyGUtjksclxu6ugsxGW8IszvpnblPXYIpZUJVechVzpx2wGJ8JXNrYJDW4lQjw3Ic8tcHZ4gdpfRYj4pFAPy6C7jrxymgSQmBGdwZ6fEsiH5wmz4DQAqYDxV79BdzAFODXKL4EweRoHRmHSCK2SrHn7BN5ORG0D5lC57ynCxdW6X17f8kdMvDxuv36tDDNdVLJmg2A9K3vgGNZvPSce3eLNV5ts5A4fwfzlbw7A2LyBHyxWzuSp3H7SHyj3EDl0mPowbo5GN1RikV9eoCcSRRnj8M78D3aAPpYFsqYanOn8xD3xzkqijzAB3PCWzndKrtoHC0st8EodHcj93jkl9LAsyjaLB9wijlHjMzvNHd1aM3hnj0JUPBsaNScpyBCYsWibhGjPRX17U5rrdSBFMB6UiSacPNuTQIUEZDWmHSUp4LU6jJniIUgKlVBg5jUbbjAc8ZklUA6SnTxvac2zLP69AOf8Zgd9heBuwvrjFzQZHpSgJYyVVXTJSMPYz8cPyMxKyAbZ9dA1efW4WLSMhET1OMQMMdzmuqshTSRYtUiuvSTplUg"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                IssueHistory issuehistory = createIssueHistory();
                java.lang.reflect.Field field = issuehistory.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        issuehistory.setComments(contraints.getNegativeValue().toString());
                        validateIssueHistory(contraints, issuehistory);
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
