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
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.CreateProjectRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.CreateProject;
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
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectAccessRights;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectAccessRightsRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectUserMapping;
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
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class CreateProjectTestCase extends EntityTestCriteria {

    @Autowired
    private CreateProjectRepository<CreateProject> createprojectRepository;

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

    private CreateProject createCreateProject() throws SpartanPersistenceException, SpartanConstraintViolationException {
        ProjectAccessRights projectaccessrights = new ProjectAccessRights();
        projectaccessrights.setProjectAccessName("zEbKyWzi6h3qgT74JpbvfDfJcp9XIELMohQ1INDYxJR46dCbsa");
        projectaccessrights.setProjectAccessDesc("YyAWrvrpL88P0sGEYQ4i0WavvsmjZOyJoSBriA1jbeU3DXFxHB");
        ProjectAccessRights ProjectAccessRightsTest = projectaccessrightsRepository.save(projectaccessrights);
        map.put("ProjectAccessRightsPrimaryKey", projectaccessrights._getPrimarykey());
        CreateProject createproject = new CreateProject();
        createproject.setProjectAccessCode((java.lang.String) ProjectAccessRightsTest._getPrimarykey()); /* ******Adding refrenced table data */
        createproject.setProjectShortName("7WhwM1xSAB9UQVilINLzsUVbk3ITDdCdPXQrEP2bWi8aM9Y5FX");
        createproject.setDateOfCreation(new java.sql.Date(123456789));
        createproject.setBuild("LEHg9S1unZReuFeazeBbHXzZfLzN4y0OMceXOIA8nIeeXTkXY7");
        createproject.setVersion("QBAgePUnhjFNnYrYMQyLJbbhcFlqhusfUtS1b5Grn1Zi4OHeHN");
        createproject.setProjectName("jnt49nBTK1a9TjwBJQTEkARoH3boc3ExTMhfsQMDVv6gvb9Enb");
        createproject.setProjectDescription("HRiQGSSnWAe8iEU05Qx4ODnOxQaiiKTnzehaFu8cKC2NeE2g6w");
        createproject.setProjectURL("SUcMISpJ5jo3FSquNP9wn4nYRbzPsyCzTDoTuEQ4JMFcKUmA4b");
        java.util.List<ProjectUserMapping> listOfProjectUserMapping = new java.util.ArrayList<ProjectUserMapping>();
        ProjectUserMapping projectusermapping = new ProjectUserMapping();
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("H6JAMXZ1gUqzVGZuBHkaz6LWMxmCTrejuHDopl7wWJEvm3nQPp");
        corecontacts.setMiddleName("cMcZj8tyjMdGPQlwCKbXPQ6PGAxDDhzDYAQql8SlMgfXnWNb4V");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("ludO3NZhDIALa6OFDctpAvQ3A6eaPAVdKOeBXfPFVBM0nOutYz");
        timezone.setTimeZoneLabel("NYkOj8OiWrLKVSfQ6r3FBamGWrClca7lQNfiGr7wGkGS7ZbOcS");
        timezone.setCountry("rEDzXpiyjk1j1mAijO8CNOwJUrUX00KCSfNhpGEISMlEv4ROkt");
        timezone.setCities("yh5wscSvsU1SrC2a8GHfFYVDYrMEqRU0bg7VNhzbWf4HqeJWhn");
        timezone.setUtcdifference(9);
        Title title = new Title();
        title.setTitles("hXuNZsXwyPlWsIif1I1lqKg6dvnbuN1kdcKhcxk9F8F9c1eBge");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("rvB4M6zdX26D8v6Eyg7xOsVw17UIprJvifxXWp81TlNYHSgWuG");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("3ui7RUSjHl48f9bHzKBepPkV7kyzfAoQw47s7Jm0xyrfJQFO7v");
        language.setAlpha4parentid(6);
        language.setAlpha2("1a");
        language.setLanguageIcon("0Cmg9is4AxpOiXaR7ZN3pxPKb0kIrRY9JCdZ2HLFwUllsEL0xa");
        language.setAlpha4("4olD");
        language.setAlpha3("mZL");
        language.setLanguageType("CMnqyP3udvXD6vfNvVpVbzZRegQAhvJx");
        language.setLanguageDescription("ZiJzXwvV6xuBHxWb4uEui5j7GsYIVm8XeL0Dt7tZKen5pNAwCO");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("eIPBpCRiTt8pTuW0Vkw5qoeFlvjQbb7tj01hAu8NoVXJEyGLOG");
        corecontacts.setMiddleName("hEN3lZU9wHencmFWvfWWbOMiUwHFtwbPF6pAFkKIrjZRv9QazP");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("CkJQUSzn68QNK3aExRZ1FKXnL9if0g8H12oZJzntsQ15yvTBaY");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127869309l));
        corecontacts.setAge(19);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("mavZ1219RwPxBD3pU6NLQdNBJryfR27VhYxwlZZQpx7cHPM5Ct");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("445aEdoGyKwtF5olUY1NZZBsbACNiilBnCgnKq322UkN8bvtD5");
        corecontacts.setPhoneNumber("KUSRrPbrOVS7gS3bnVmn");
        corecontacts.setEmailId("eZctEDbFCigFe2C2lL7b2ZoT0aMuvAko9WQgcnyVQkGnuSrvn2");
        corecontacts.setNativeMiddleName("cDan1gpb2emaQ29zJibx1LmVeHiXC4NihApvJyKCt52PTLwMmZ");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127869425l));
        corecontacts.setNativeTitle("qE9P3eLDG89ouQsLukuoq2nIDPzm2sGBjej2AQPaYwwtsb0ebD");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("YFUBOpbQi7kAxX4bJgFXG9rrpnAL0GyHqJNzmN30Tx9HGUAGjs");
        country.setCountryCode1("3Qy");
        country.setCapitalLongitude(10);
        country.setCurrencyName("7Jl3nasmVU5klfTqurmo4Bji3iO7WtzTfjAefHsfUJ4a5FozDT");
        country.setCurrencyCode("YDU");
        country.setCountryFlag("JQfLyDjxqcCdqQe2470TBUjnvwPRRE1NIxGa7xmNbtm5haeIDl");
        country.setIsoNumeric(6);
        country.setCapitalLatitude(11);
        country.setCapital("HlQPjqdHdN5JGtH9KqXZ2fUA1S5e6BpB");
        country.setCountryCode2("HXa");
        country.setCurrencySymbol("iSStkrjPAIwL0eMFpSyGJ6va5A5aBx83");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("D8qeF11TVeTYouSdZBx3Ep9saNd8X4ySPzPNXI5BLqgQsGAqHI");
        city.setCityLongitude(3);
        city.setCityLatitude(6);
        city.setCityDescription("NwOaW9EaMngogFghdC5RqMdUVq7fhnKFO3VuyNLa9q8VxpwE1E");
        city.setCityCode(3);
        city.setCityName("vlGeBIaif69VNy8QgSBFAJ3u5sHByUEHo4taY1XDXGP9B995FP");
        State state = new State();
        state.setStateCodeChar2("D3nFPdS8hKEHfOWs9nmep7Q3uivvQyPF");
        state.setStateCapitalLongitude(6);
        state.setStateCodeChar3("tDin4TW2jyhVPWOp2bbltJVYaHPT30Lz");
        state.setStateCodeChar2("WOFUiD3fl3U7hXi6fBf1Aejp6MM5O5TK");
        state.setStateCapitalLongitude(3);
        state.setStateCodeChar3("ubffjzSDd5jesjORiOCOkcX5IUUWa3cq");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("Z5DoRrRgjC66GWBxrWhkYDAujD6jwuoef9P4KHMRwuge6W8Tei");
        state.setStateFlag("fn3qdGOmOancIlUiaeJaQwr33bq8Fk7rEf4PQXRvnr4pqa3gKE");
        state.setStateCapital("OWgji8iHnCgiq6ckZeOBBmTQg20ijcXJfrWj41u6Qd2LNScwub");
        state.setStateCapitalLatitude(2);
        state.setStateDescription("dz4da4OHlWkV8Ubj4gXzVf48LpQFzxMY5r0hsJawhD5uGlaAJ2");
        state.setStateCode(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("TaYT9b0BNadeYpo5S1UwBHveftexf8tXg8IKE9qP4JeSpNOK8v");
        city.setCityLongitude(4);
        city.setCityLatitude(11);
        city.setCityDescription("kjYgFFYfpkYUFsdnBQLKH4Y08CsX6dMZuXH4y9p6bUsOdPWWBe");
        city.setCityCode(2);
        city.setCityName("J2sA0iRIBUCGw0blqB4dwCFjVsVOumEKd8b4hudoJwIS4ump76");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("Y24FnlvevcqchKwVeyVmtarpQXbgIbtw");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("RjO0oM48FaVplxNwSS8pV7ztTscj3bl248rrBmfvtVNm9jYU4F");
        addresstype.setAddressTypeDesc("cvXMor0ekhQI6yBznz2uK3UU51QqoBDfmjfUQmRpiuylNs4CRf");
        addresstype.setAddressType("0VI9ZPbC8wxnXPoL9FxUONrcRIvNiC9BE7JxVszNQTGi0hBTSl");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("8R4PsGti3we5qqdfjicqErrPLniKyKDbRMeo0NmaqexhlpuAOK");
        address.setAddress1("VvvTG48bl5bmNbphCgkDTLTQtOD2Dv995oKFJTnGmTiorN7LSi");
        address.setLatitude("caV73QqqKnR0wPui8S6Bo5ArC1S3Pg6pd9BCrAXLrpbDLkOH5l");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("RP5Jg3");
        address.setAddress2("UF2phorUsIUhWsTxolxbgEQQL2rT9quRwYSq37GuZeXDPFzNAf");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("oxxgoTzyY3u");
        address.setAddress3("Yf7m2QpwyvmpyQ4T0vz17godn1NfYK5Xu1BHveyLV2VVi7X6iR");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("QF9AEO13S80zJugPdO7bdOLANxK8T4jBzfzuJ5evdhEjYJqIuY");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("dKMRmpKUnOkf1DOVj3niN0Z7f7ZwhqozPDU64R1CprTKnU6uda");
        communicationgroup.setCommGroupName("WxJ6YwK8o9t8ksObGZ25n3reJSh6OqFxOc8x9dh065uLpnUV3N");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("mgWeOxVJHhY8BikVuSzyai4i3G239farkOyyT8muecriBePpSW");
        communicationtype.setCommTypeName("tqaxWvxOcui83veBlv6Z5oH3x8f4w930Z75XKLhy1efXhNCytF");
        communicationtype.setCommTypeDescription("kH797BvUEOJ70Ns59nngxRIw60tsaNbCuOKdR2iLhC1nSWLHRt");
        communicationtype.setCommTypeName("GjcWl65dpFnBZtARfB15KGIYA6DN8VnIVLL0dBxYiOwbPt253w");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("XBcsVMdMuq2hEU7tfCVcXST7otOmQE3qaS9HGeSwqcWTRaT4RH");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        projectusermapping.setCreateProject(createproject);
        projectusermapping.setIsAdmin(true);
        projectusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey());
        listOfProjectUserMapping.add(projectusermapping);
        createproject.addAllProjectUserMapping(listOfProjectUserMapping);
        createproject.setEntityValidator(entityValidator);
        return createproject;
    }

    @Test
    public void test1Save() {
        try {
            CreateProject createproject = createCreateProject();
            createproject.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            createproject.isValid();
            createprojectRepository.save(createproject);
            map.put("CreateProjectPrimaryKey", createproject._getPrimarykey());
        } catch (com.athena.framework.server.exception.biz.SpartanConstraintViolationException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Autowired
    private ProjectAccessRightsRepository<ProjectAccessRights> projectaccessrightsRepository;

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

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            CreateProject createproject = createprojectRepository.findById((java.lang.String) map.get("CreateProjectPrimaryKey"));
            createproject.setProjectShortName("Qtxr3s6bdObHz06AelEBkxiyFChu3uZOVLS4YyJShOGfA8Vekm");
            createproject.setDateOfCreation(new java.sql.Date(123456789));
            createproject.setBuild("3Io8wEjLDY60AkekHW1iZ55hzNC0bUAHVnypiaEVYGqt49mvqH");
            createproject.setVersionId(1);
            createproject.setVersion("XiLLJnvD1sRPyvcNEckoZLGDCi8fsrbZWsfrvZw1p4fTkyoy8T");
            createproject.setProjectName("FXDA5N5oTaqNQ7cp4w6lwgDY5lHdT4MRHSENpoGE2vlOTGq4BG");
            createproject.setProjectDescription("dyHtxAwK1W9M9H93VVMgLxktuLZiiR2VtBTn7EOu4sT4whfpLv");
            createproject.setProjectURL("9uorSgj5G58nUS0TrLihaZ0Rrdx2gtVCCNUMGTpj089F5OnZTm");
            createproject.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            createprojectRepository.update(createproject);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findByprojectAccessCode() {
        try {
            java.util.List<CreateProject> listofprojectAccessCode = createprojectRepository.findByProjectAccessCode((java.lang.String) map.get("ProjectAccessRightsPrimaryKey"));
            if (listofprojectAccessCode.size() == 0) {
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
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            createprojectRepository.findById((java.lang.String) map.get("CreateProjectPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("CreateProjectPrimaryKey"));
            createprojectRepository.delete((java.lang.String) map.get("CreateProjectPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateCreateProject(EntityTestCriteria contraints, CreateProject createproject) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            createproject.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            createproject.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            createprojectRepository.save(createproject);
        }
    }

    private List<EntityTestCriteria> addingListOfFieldForNegativeTesting() {
        List<EntityTestCriteria> entityContraints = new java.util.ArrayList<EntityTestCriteria>();
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 1, "projectName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 2, "projectName", "Gp7CTWzngiXXOHujl0zNzQ7r1nsiPOtiZRf4KAxQXNUtYI2mKkiotoBrs2BeAMP80Rb7bQ6NYScOnwNPdeie48jFFosoP97Kv5OK4VqMtjyTKnAOAxM8dilK0ZgPdTAWo"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 3, "projectShortName", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 4, "projectShortName", "cvneErmjpnKS7ZNyTABCWVjlfD6QyMRcUr2UMPQbKoaKJxn7fRfIDbrHif1fxNrV2"));
        entityContraints.add(new EntityTestCriteria(NOT_NULL, 5, "projectDescription", null));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 6, "projectDescription", "vlc30OTUHzRT2BrrM6MV3NEQfElpZb1dw0PSBYDTlTxzkH6t235gTsEnU823gqmPypuLjaTX0atOCR0h6LFho9InOevLf2FUO8ShsNKEqgAdS4eRul4HgCCEh6lUcfEcfDZYtoC4JbK7u8tdfVmh3eaAR13Q0lZTNcqZzLXyXpJPyiRvpD4SSeqTFcKwYjHBrAQGIemAxCuUAxwXcmYlubiDS3kkvJAo3lFe35zjNA7BSbQduj0jpCrticzro3dmxOoLMPuzGcKaAEVDuJnc00iThU2id96PSayee1nIp6DotuA9W28bZmpS6WMM9XlIVH5iyjFPXtevRiRPGSOYwNGeJUiUALWqm1Kcz06qF8T2AcIb5o6ieoP6eVUXUilnqp0lZaeQpxcgg0YuesKpLJuQqzjWq85ec6PAXf8mKmvD4yFsPTdYgtuivLk2whc9LIisZUCEpawSEsl4IIGD28oS0g54nClpoewMHVVga4zjlyRH7b1tgkoEB6PlsDGSShSBtt1U284q87yZhlOqL2EYduhAnmjbDxQUfgum95UEMRLHP0M3H4g29SCsWBP6QyRiu2aYI8FecSiKvHTPvJyEvyseMMaXrzeJAcvItnVZusGmxSTttIbUizI2VLEo4tfYXdEIKHbCNqZhLQKOdpJU4iah5LvfTaDLDFKQk66MVxsDEcmRL0IuBzFy24W8gnLOYQpxvaYsOrRyNSLjfr1hpHOEEGr779bktJAMGPIlbBMOq9dVYr2YcBbBpl4yRyWNEIuTp3f04XA1bVKe0zXxh3M4UsCvxEFxRviVNqYFofl6T0cmllTDU2Jzt0DerweDIBmeR9QoQMTKA1hq7ZiS28SrCpTsbv26VLy9VSJsgBIHb9RwgHqWS3rjtUbtkJqHw168KsbrcOBGFhmfv0aMhjwYWXX2QrsJ6978x8jsrjTSsP0H8BO2gYFNQmPLyN7J7sa5L6YadpVL7HLtriKjfq4370G3DxeMRVk5Nxn3WwfCcaGFoV7PzQND1WgAz"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 7, "projectURL", "vr7MO3abo32Sio71vfTP5dk5bO12OPz9BVZGlQWWnm332p0QnAYNVaWiSlqesltDt"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 8, "version", "dgUagrAy97JxQ3hiMhedLFdJZ2dJzWvd27EKjdXIcHovnMFA0NhBGJQaOSSDMiunN"));
        entityContraints.add(new EntityTestCriteria(MIN_MAX, 9, "build", "KkiJ6TYOi3aonmGzTNf7RsvQ25qXt7lAGma8u6goXOV1AVjfqRsqX8dqLgzQjC2TT"));
        return entityContraints;
    }

    @Test
    public void test5NegativeTesting() throws NoSuchMethodException, SecurityException, IllegalArgumentException, IllegalAccessException, NoSuchFieldException {
        int failureCount = 0;
        for (EntityTestCriteria contraints : this.entityContraint) {
            try {
                CreateProject createproject = createCreateProject();
                java.lang.reflect.Field field = createproject.getClass().getDeclaredField(contraints.getFieldName());
                switch(((contraints.getTestId()))) {
                    case 0:
                        break;
                    case 1:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 2:
                        createproject.setProjectName(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 3:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 4:
                        createproject.setProjectShortName(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 5:
                        field.setAccessible(true);
                        field.set(createproject, null);
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 6:
                        createproject.setProjectDescription(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 7:
                        createproject.setProjectURL(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 8:
                        createproject.setVersion(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
                        failureCount++;
                        break;
                    case 9:
                        createproject.setBuild(contraints.getNegativeValue().toString());
                        validateCreateProject(contraints, createproject);
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
