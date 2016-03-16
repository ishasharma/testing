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
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.RoleUserMappingRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.RoleUserMapping;
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
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.ProjectRoles;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.ProjectRolesRepository;
import issuetracker.app.shared.issuetrackerboundedcontext.projectmanager.IssueVisibility;
import issuetracker.app.server.repository.issuetrackerboundedcontext.projectmanager.IssueVisibilityRepository;
import com.athena.framework.server.exception.biz.SpartanConstraintViolationException;
import com.athena.framework.server.exception.biz.SpartanIncorrectDataException;
import com.athena.framework.server.exception.repository.SpartanPersistenceException;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = WebConfigExtended.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TestExecutionListeners({ org.springframework.test.context.support.DependencyInjectionTestExecutionListener.class, org.springframework.test.context.support.DirtiesContextTestExecutionListener.class, org.springframework.test.context.transaction.TransactionalTestExecutionListener.class })
public class RoleUserMappingTestCase extends EntityTestCriteria {

    @Autowired
    private RoleUserMappingRepository<RoleUserMapping> roleusermappingRepository;

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

    private RoleUserMapping createRoleUserMapping() throws SpartanPersistenceException, SpartanConstraintViolationException {
        CoreContacts corecontacts = new CoreContacts();
        corecontacts.setFirstName("IYxaUkiMgQcGdb5W8BG6Eit0ilihc43TGHkCzzkBdzgFlgd9Sd");
        corecontacts.setMiddleName("77RO6GgoME9tDzQjEzZ2NXNtrP09i9d1uAniMACkOLBnMU5DGf");
        Timezone timezone = new Timezone();
        timezone.setGmtLabel("4BcLollVKBndiLvhfj1FJgYyAqhnmObdweCnnuML9MxAszdya7");
        timezone.setTimeZoneLabel("oER4STryQj5yWC05zIgzXwFseht4sDsejzHppX9nbCPSL1MiQ3");
        timezone.setCountry("yFOccJWmFTmffeJOJzdpSdyWDIPVIIP8MUBqgXOdjDJaWrqewU");
        timezone.setCities("x4tutVQpTnPHi2O0uy5xrGGohtRKA01KyLm5VvUR5KzLrWhg01");
        timezone.setUtcdifference(10);
        Title title = new Title();
        title.setTitles("6D6b3CYf4vPmRu4n2mAHleKnWh662PcqrdILgydUuxFzfIvLsb");
        Title TitleTest = titleRepository.save(title);
        map.put("TitlePrimaryKey", title._getPrimarykey());
        Gender gender = new Gender();
        gender.setGender("WZF7042jOUiOi6pdBzQq9lRXzwj0kKJjd14CubMt0wxi5ZCIuC");
        Gender GenderTest = genderRepository.save(gender);
        map.put("GenderPrimaryKey", gender._getPrimarykey());
        Language language = new Language();
        language.setLanguage("4LUqfqQA6vUY1bNxdcg5FQ6MNx9ozHrBFSrJm5CfAmJHF5lyaH");
        language.setAlpha4parentid(4);
        language.setAlpha2("P0");
        language.setLanguageIcon("8IFWoPyuDw5Fn381pcFq53BaCHoiAfVamdQ7mDkBUl3mNjfSEl");
        language.setAlpha4("tiBM");
        language.setAlpha3("Rxc");
        language.setLanguageType("yIqDjSPZgjlXemB5nGHj0pZiRJMYiXE4");
        language.setLanguageDescription("qKVSdJllHsLwkws7jQ2jiIsYXHBvhB90m6uOsokGFtnzMYcRVL");
        Language LanguageTest = languageRepository.save(language);
        map.put("LanguagePrimaryKey", language._getPrimarykey());
        corecontacts.setFirstName("P7HVrHntod6Ukt9NWFORclPZL0xz0uWLM3e6CZX7RzaBPUMHll");
        corecontacts.setMiddleName("8wcL7DLqC3kEkoBaQL631fnLINegK84w8qtB2IwfxnyB3YLlqr");
        timezone.setTimeZoneId(null);
        corecontacts.setTimezone(timezoneRepository.save(timezone));
        map.put("TimezonePrimaryKey", timezone._getPrimarykey());
        corecontacts.setNativeLastName("UebGrW4tmgKKNpf7glCw0CWcGnuEJdEWZGm1LaQpduGzVeW3Wq");
        corecontacts.setApproximateDOB(new java.sql.Timestamp(1458127876697l));
        corecontacts.setAge(35);
        corecontacts.setTitleId((java.lang.String) TitleTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setLastName("xt8zLLCisHw4KGM6KPI5oyQOZKrtgNCOGhWv3MLmKXQQr0npO9");
        corecontacts.setGenderId((java.lang.String) GenderTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeLanguageCode((java.lang.String) LanguageTest._getPrimarykey()); /* ******Adding refrenced table data */
        corecontacts.setNativeFirstName("Kv2amgh3aIWMuS9LcmWaSdQ1MqSlHTwXz32Qnxfze5ac3chyTI");
        corecontacts.setPhoneNumber("lfvPpKIPw5LM6hy8XI5J");
        corecontacts.setEmailId("A0AlnZgu6Qf1eF1c1u2mdW2EwX0OXk8EFnliFOnh3MTB6rBu4e");
        corecontacts.setNativeMiddleName("c2lxIPRhAv6ENzP3KXiZ1nDmhXzUxMFbplZ80d1wu3nD49sQRe");
        corecontacts.setDateofbirth(new java.sql.Timestamp(1458127876808l));
        corecontacts.setNativeTitle("TkUffexAfVaSeqeHdh1nUgaMN6M2mBDF8kz6918gR5Lah60G35");
        java.util.List<Address> listOfAddress = new java.util.ArrayList<Address>();
        Address address = new Address();
        Country country = new Country();
        country.setCountryName("PLNVTfCUSFcv6qdeQpjN68fnkItlM6YIJdb1oY21eBP4BmADVd");
        country.setCountryCode1("a0c");
        country.setCapitalLongitude(8);
        country.setCurrencyName("9VekZDZB2LWHQeneb8j1jGzKRP8bAlwwtY0khQvQWssGp5m6gE");
        country.setCurrencyCode("wcu");
        country.setCountryFlag("bLiceqyXQIPy5RQDoa0YPaugTVUVPbPdomcTI0HRtLNa4wWCFN");
        country.setIsoNumeric(2);
        country.setCapitalLatitude(6);
        country.setCapital("2UVgUjsyOK6HmQPr9U5d958SbNrLYrbr");
        country.setCountryCode2("GKG");
        country.setCurrencySymbol("x6FUKDD0VdI3hUKnnAeHLwOXHEa8E7vV");
        Country CountryTest = countryRepository.save(country);
        map.put("CountryPrimaryKey", country._getPrimarykey());
        City city = new City();
        city.setCityFlag("0JyT4acx73mM7wVIVaSA3Y8OtEA9Ob07DAiBGBGHJtje7lnD53");
        city.setCityLongitude(9);
        city.setCityLatitude(5);
        city.setCityDescription("vzAyv7fBwXBeGir3OMkvmsfqRI84rIp5gTfaSSNlG9Z6gRjLP5");
        city.setCityCode(1);
        city.setCityName("nm8m3uuTMCO6CkX6XT2Hj7qgsJgIEmg2OMKK99frmvFSgl5uEp");
        State state = new State();
        state.setStateCodeChar2("R9IRYaaMIrhVaauFA46MtwrzAUxHIPgx");
        state.setStateCapitalLongitude(2);
        state.setStateCodeChar3("bOcGFDK6XYmIjpujtu8bc258gJhu4sEe");
        state.setStateCodeChar2("w1jJS0beMnymUX97bWXeUd7iTHMUg7gk");
        state.setStateCapitalLongitude(5);
        state.setStateCodeChar3("o6agvT4Ld4EWHH7nzun3vLqxok9mGUor");
        state.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        state.setStateName("ya0yeO237YrrujCXgbDeUFUKYNjY6fD1MXhytAzYw5dq7tiPmk");
        state.setStateFlag("fskP5hKl3hmrO4EymMV9DcusnbrC1gS0wEh9318ApGVINhf6Ua");
        state.setStateCapital("ShUaMEkmSv2ImpaFoLCEFsIER1cpcvndUlbUBWaESKV4mv3pQs");
        state.setStateCapitalLatitude(11);
        state.setStateDescription("3j6T1JKQXmHHW5DgD7z9YprJs0dhXXZV7wyhsvsN8R1FiCFoPS");
        state.setStateCode(2);
        State StateTest = stateRepository.save(state);
        map.put("StatePrimaryKey", state._getPrimarykey());
        city.setCityFlag("Cr5zhSC1pK2s9eSXmnPK0XVoYVQz0lBafoRDug2bAJCmYTsx8t");
        city.setCityLongitude(9);
        city.setCityLatitude(4);
        city.setCityDescription("0MxTsr4iBCck9epgua2sMc1WgqL12A8G6Z9MWfi6REGtqPFEQW");
        city.setCityCode(2);
        city.setCityName("NmZMBKS0u4n1XBxvaAKpKQg0jjILrUt3fCogXG2nI6S3xfRxMy");
        city.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        city.setCityCodeChar2("HzbT7Um8YR4UjecJKwAQR9jJGWA5Mj7V");
        city.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        City CityTest = cityRepository.save(city);
        map.put("CityPrimaryKey", city._getPrimarykey());
        AddressType addresstype = new AddressType();
        addresstype.setAddressTypeIcon("BHLdNpomw0tlcmoieIoYpXAdT0rphBLfEy5xYoHXR0Uio8UcNV");
        addresstype.setAddressTypeDesc("6oQPiKO4idv4Dzr8D1dVYxW9BwzfhoHTPej7Cjd42MNrhFRWMG");
        addresstype.setAddressType("aqPbHWmCFFhW3Cz9MDVkrdm5r56TBmoZbnaUTy5YSvTQmkyux6");
        AddressType AddressTypeTest = addresstypeRepository.save(addresstype);
        map.put("AddressTypePrimaryKey", addresstype._getPrimarykey());
        address.setCountryId((java.lang.String) CountryTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setLongitude("JsUs2LvgmIcXFyLj66WKpBBMwy4W93Xii08Z4Zqr3m3olmDZkN");
        address.setAddress1("OwvRUIa4pwrb6rAwQ1PhQofsUJmHIz9hRebbPtwztgGPADWYa7");
        address.setLatitude("m6GMpsBs1EwqO4ykiQ7VCEIfvEFaAKhwVCLaslf7KULt644wrY");
        address.setCityId((java.lang.String) CityTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressTypeId((java.lang.String) AddressTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setZipcode("A5N3IW");
        address.setAddress2("qgc1flwti73kphNmqcZqCWpSGeocV8jaKknTMKRjFpuwR2EFim");
        address.setStateId((java.lang.String) StateTest._getPrimarykey()); /* ******Adding refrenced table data */
        address.setAddressLabel("o8N7haiEPZa");
        address.setAddress3("PsaSkgjttKI3zyDN8ssuVcIII7kr4dkx1z9pJFUnGzJidotQv3");
        listOfAddress.add(address);
        corecontacts.addAllAddress(listOfAddress);
        java.util.List<CommunicationData> listOfCommunicationData = new java.util.ArrayList<CommunicationData>();
        CommunicationData communicationdata = new CommunicationData();
        communicationdata.setCommData("WKiBRHDS51yYxserZqHqP5GqdSamM4PHuitUwFCkv0J1AVL7ZK");
        CommunicationGroup communicationgroup = new CommunicationGroup();
        communicationgroup.setCommGroupDescription("HsiJpdrLmOWEtmSpG7hgRPUOqNQhj5QFXq2JGxIhTGSRs5wrcz");
        communicationgroup.setCommGroupName("aE4R0tilZvmgmKjS8lxZCoKJCqdIPjTnJmTsprxoaGK1yQ221K");
        CommunicationGroup CommunicationGroupTest = communicationgroupRepository.save(communicationgroup);
        map.put("CommunicationGroupPrimaryKey", communicationgroup._getPrimarykey());
        CommunicationType communicationtype = new CommunicationType();
        communicationtype.setCommTypeDescription("rD1tJS5KbThJvoinbZH3slUwnlKeCcAMrvVOTFVq9tlfeSC2MN");
        communicationtype.setCommTypeName("lTo9kZMexupM9wUk1xubHEe050FGICpvevz6o6nFW8tTRffGcq");
        communicationtype.setCommTypeDescription("FVTxtBai0v4tvR9yWleGP65sjNVZDW0Xysgc8H7VQXwxuOvhtC");
        communicationtype.setCommTypeName("WJaLQIR2N7hkB7euf3ZjIM5Y55Z2VNY5iKF2YHOxFUnSOYFwI1");
        communicationtype.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        CommunicationType CommunicationTypeTest = communicationtypeRepository.save(communicationtype);
        map.put("CommunicationTypePrimaryKey", communicationtype._getPrimarykey());
        communicationdata.setCommData("aKwrejJ7eEAbtUKpMtjXISe0Y9hL5r2B5rc2odalbuJMQKCLgg");
        communicationdata.setCommGroupId((java.lang.String) CommunicationGroupTest._getPrimarykey()); /* ******Adding refrenced table data */
        communicationdata.setCommType((java.lang.String) CommunicationTypeTest._getPrimarykey()); /* ******Adding refrenced table data */
        listOfCommunicationData.add(communicationdata);
        corecontacts.addAllCommunicationData(listOfCommunicationData);
        CoreContacts CoreContactsTest = corecontactsRepository.save(corecontacts);
        map.put("CoreContactsPrimaryKey", corecontacts._getPrimarykey());
        ProjectRoles projectroles = new ProjectRoles();
        IssueVisibility issuevisibility = new IssueVisibility();
        issuevisibility.setIssueVisibilityName("jqrlfBIfsc3Dnwy39gAlOpYYkW7vbUB5t6Si2WYNYurEsBLztV");
        issuevisibility.setIssueVisibilityDesc("gYMQ7IsRuSO2RQky00M2rTOvRZMfrBurEBkkt50ZAXz3t9ysS9");
        IssueVisibility IssueVisibilityTest = issuevisibilityRepository.save(issuevisibility);
        map.put("IssueVisibilityPrimaryKey", issuevisibility._getPrimarykey());
        projectroles.setIssueVisibilityCode((java.lang.String) IssueVisibilityTest._getPrimarykey()); /* ******Adding refrenced table data */
        projectroles.setCanAssignRole(true);
        projectroles.setRoleName("Yiv03A3Tx8tC3i8IBHiCUfObFS1mmC2ncf3xcJFv9DyuDmDwj8");
        ProjectRoles ProjectRolesTest = projectrolesRepository.save(projectroles);
        map.put("ProjectRolesPrimaryKey", projectroles._getPrimarykey());
        RoleUserMapping roleusermapping = new RoleUserMapping();
        roleusermapping.setContactId((java.lang.String) CoreContactsTest._getPrimarykey()); /* ******Adding refrenced table data */
        roleusermapping.setPrjRoleId((java.lang.String) ProjectRolesTest._getPrimarykey());
        roleusermapping.setEntityValidator(entityValidator);
        return roleusermapping;
    }

    @Test
    public void test1Save() {
        try {
            RoleUserMapping roleusermapping = createRoleUserMapping();
            roleusermapping.setEntityAudit(1, "xyz", RECORD_TYPE.ADD);
            roleusermapping.isValid();
            roleusermappingRepository.save(roleusermapping);
            map.put("RoleUserMappingPrimaryKey", roleusermapping._getPrimarykey());
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
    private ProjectRolesRepository<ProjectRoles> projectrolesRepository;

    @Autowired
    private IssueVisibilityRepository<IssueVisibility> issuevisibilityRepository;

    @Test
    public void test2Update() {
        try {
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            RoleUserMapping roleusermapping = roleusermappingRepository.findById((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
            roleusermapping.setVersionId(1);
            roleusermapping.setEntityAudit(1, "xyz", RECORD_TYPE.UPDATE);
            roleusermappingRepository.update(roleusermapping);
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (java.lang.Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test3findBycontactId() {
        try {
            java.util.List<RoleUserMapping> listofcontactId = roleusermappingRepository.findByContactId((java.lang.String) map.get("CoreContactsPrimaryKey"));
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
    public void test3findByprjRoleId() {
        try {
            java.util.List<RoleUserMapping> listofprjRoleId = roleusermappingRepository.findByPrjRoleId((java.lang.String) map.get("ProjectRolesPrimaryKey"));
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
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            roleusermappingRepository.findById((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    @Test
    public void test4Delete() {
        try {
            org.junit.Assert.assertNotNull(map.get("RoleUserMappingPrimaryKey"));
            roleusermappingRepository.delete((java.lang.String) map.get("RoleUserMappingPrimaryKey"));
        } catch (com.athena.framework.server.exception.repository.SpartanPersistenceException e) {
            org.junit.Assert.fail(e.getMessage());
        } catch (Exception e) {
            org.junit.Assert.fail(e.getMessage());
        }
    }

    private void validateRoleUserMapping(EntityTestCriteria contraints, RoleUserMapping roleusermapping) throws SpartanIncorrectDataException, SpartanConstraintViolationException, SpartanPersistenceException {
        if (contraints.getRuleType() == MIN_MAX) {
            roleusermapping.isValid();
        } else if (contraints.getRuleType() == NOT_NULL) {
            roleusermapping.isValid();
        } else if (contraints.getRuleType() == UNIQUE) {
            roleusermappingRepository.save(roleusermapping);
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
