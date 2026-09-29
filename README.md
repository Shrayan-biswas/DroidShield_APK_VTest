<div align="center">

# 🛡️ DroidShield

### Android Security Testing & Content Provider Analysis

**A hands-on Android security lab focused on component exposure, Content Provider behavior, and practical security testing.**

![Platform](https://img.shields.io/badge/Platform-Android-3DDC84?logo=android\&logoColor=white)
![Language](https://img.shields.io/badge/Language-Java-orange?logo=openjdk\&logoColor=white)
![Focus](https://img.shields.io/badge/Focus-Mobile%20Application%20Security-6C63FF)
![Status](https://img.shields.io/badge/Status-In%20Progress-orange)
![Testing](https://img.shields.io/badge/Testing-Authorized%20Lab-blue)

</div>

---

## 📖 About the Project

**DroidShield** is a student-built Android security testing project created to explore how Android application components expose functionality and data.

The project currently focuses on **Content Provider security**, using the DIVA intentionally vulnerable Android application as a controlled training target. A separate Android test client was developed to interact with the provider and demonstrate selected database operations.

The purpose of this project is to:

* Understand Android application components and their security boundaries.
* Inspect manifest declarations and component exposure.
* Review Content Provider implementation and access-control behavior.
* Demonstrate provider operations from a separate client application.
* Record test results and explain their potential security implications.
* Document practical remediation recommendations.

> **Current scope:** DroidShield is a focused lab test client and analysis project. It is not yet a general-purpose APK scanner, automated vulnerability detector, or complete mobile security assessment framework.

---

## 🎯 Project Objectives

### 1. Android component analysis

Study how Android components are declared and how configuration affects whether other applications can interact with them.

### 2. Content Provider testing

Examine a provider's authority, exported status, and available operations. Review how query and database operations are implemented.

### 3. Practical validation

Use a separate Android client to test provider behavior in an authorized lab environment.

### 4. Security documentation

Record observed behavior, explain possible risks in production applications, and recommend appropriate controls.

---

## 🧪 Lab Environment

| Item                | Details                                    |
| ------------------- | ------------------------------------------ |
| Target application  | DIVA Android training application          |
| Target component    | Notes Content Provider                     |
| Provider class      | `jakhar.aseem.diva.NotesProvider`          |
| Provider authority  | `jakhar.aseem.diva.provider.notesprovider` |
| Test client package | `com.droidshield.providercheck`            |
| Client language     | Java                                       |
| Testing environment | Controlled, authorized lab                 |
| Main testing focus  | Exported provider and CRUD behavior        |

DIVA is intentionally vulnerable and is used as a training target. The results described here apply to the reviewed lab application and test runs; they should not be assumed to apply to other applications.

---

## 🔍 Current Security Assessment

### Finding: Exported Notes Content Provider

**Finding type:** Android component exposure
**Target:** DIVA Notes Content Provider
**Status:** Lab observation documented
**Severity:** Not formally rated

#### Summary

The Notes Content Provider is declared as exported in the DIVA application manifest. During the source review performed for this lab, the reviewed provider methods did not show apparent permission-enforcement checks.

The separate test client demonstrated provider operations against the lab application.

This observation identifies a potential access-control concern. The actual impact in a production application would depend on the data exposed, provider implementation, caller permissions, and other application controls.

#### Manifest observations

| Property                   | Observed value                             |
| -------------------------- | ------------------------------------------ |
| Provider authority         | `jakhar.aseem.diva.provider.notesprovider` |
| Provider class             | `jakhar.aseem.diva.NotesProvider`          |
| Enabled                    | `true`                                     |
| Exported                   | `true`                                     |
| Read permission attribute  | None observed in the reviewed declaration  |
| Write permission attribute | None observed in the reviewed declaration  |

#### Implementation review

The provider implementation reviewed for this lab included methods for:

* Querying notes
* Inserting notes
* Updating notes
* Deleting notes

The reviewed methods used database operations for the notes table. No apparent permission checks were identified in the reviewed method paths.

This is a scoped code-review observation, not proof that every possible access path or runtime configuration has been exhaustively tested.

---

## 📊 Test Results

The following results were recorded during the lab runs:

| Test   | Recorded result                                |
| ------ | ---------------------------------------------- |
| Query  | 6 rows returned                                |
| Insert | Test note inserted; a content URI was returned |
| Update | 1 row updated                                  |
| Delete | 1 row deleted                                  |

The update and delete tests used a test note created for the lab.

These results demonstrate the behavior observed in the recorded tests. They do not establish that all possible query conditions, callers, permissions, or provider configurations have been tested.

---

## 🧰 Test Client

The Android test client uses Android's `ContentResolver` to interact with the DIVA Notes Content Provider.

### Operations demonstrated

* Insert a test note
* Update the inserted note
* Delete the test note
* Query provider data in a separate recorded test

### Source location

```text
provider_test/
├── AndroidManifest.xml
└── src/
    └── ProviderCheck.java
```

The current Java source demonstrates the insert, update, and delete sequence. Query testing was performed separately during the lab.

---

## 🛡️ Security Recommendations

The following recommendations apply to applications that expose Content Providers or similar data-access components.

### 1. Disable unnecessary external access

Set a component to non-exported when it does not need to be accessed by other applications.

### 2. Enforce appropriate permissions

If external access is required, define and enforce suitable read and write permissions. Do not rely only on obscurity of the provider authority or URI.

### 3. Validate caller access

Ensure that each operation checks whether the calling application is authorized to access the requested data and functionality.

### 4. Limit exposed data

Return only the columns and records needed by the caller. Avoid exposing sensitive information through broad queries.

### 5. Validate requested operations

Review query parameters, selection arguments, URI paths, and requested database operations. Ensure callers cannot access unintended records or operations.

### 6. Retest after remediation

After applying changes, repeat the tests from a separate client and verify that unauthorized access is denied while intended application functionality still works.

---

## 🧭 Methodology

The current lab followed this general workflow:

1. Inspect the target application's manifest.
2. Identify the Notes Content Provider declaration and authority.
3. Review the provider implementation and available operations.
4. Build a separate Android test client.
5. Run provider operations against the authorized training target.
6. Record observed results.
7. Review potential security implications.
8. Document recommendations for reducing exposure.

The project is still in progress. Additional testing and documentation may expand this methodology.

---

## 🗺️ Roadmap

### Completed

* [x] Inspect the provider declaration in the manifest
* [x] Identify the provider authority and class
* [x] Review provider CRUD implementation
* [x] Create a separate Android test client
* [x] Demonstrate query and CRUD behavior
* [x] Record initial test results
* [x] Document initial security observations

### Planned

* [ ] Add organized screenshots and test evidence
* [ ] Create a detailed test environment document
* [ ] Create a repeatable test methodology document
* [ ] Document remediation validation
* [ ] Expand testing of provider permissions and access-control behavior
* [ ] Assess additional Android component types
* [ ] Improve test result presentation and reporting

---

## 📁 Repository Structure

```text
DroidShield/
├── provider_test/
│   ├── AndroidManifest.xml
│   └── src/
│       └── ProviderCheck.java
├── .gitignore
└── README.md
```

Local APKs, decoded application output, signing keys, signatures, and generated build artifacts are excluded from the repository.

---

## 🧰 Tools & Technologies

* **Android:** Android application components and Content Providers
* **Java:** Test client implementation
* **Android SDK:** Android application development and testing
* **APK inspection:** Manifest and implementation review
* **Kali Linux:** Lab environment
* **Git:** Version control
* **GitHub:** Project hosting and documentation

---

## ⚠️ Disclaimer

DroidShield is an educational project intended for authorized Android security testing.

Use these techniques only on applications and devices you own or have explicit permission to test. The DIVA application is intentionally vulnerable and is used here as a training target.

The findings and test results in this repository are limited to the described lab environment and reviewed code. They should not be interpreted as a security assessment of unrelated applications.

---

## 👨‍💻 Author

**Shrayan Biswas**
BSc IT — Information Security

Interested in Android security, mobile application testing, and practical cybersecurity research.

---

<div align="center">

**Learn • Test • Document • Improve**

</div>
