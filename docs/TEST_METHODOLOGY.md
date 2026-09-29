# DroidShield — Test Methodology

## 1. Purpose

This document describes the methodology used to examine the Notes Content
Provider in the DIVA intentionally vulnerable Android training application.

The objective was to understand the provider's exposure, review its
implementation, and observe its behavior through a separate Android test
client.

This document records the work completed so far. It does not represent a
complete security assessment of DIVA or other Android applications.

## 2. Scope

### In scope

- Reviewing the target application's Android manifest
- Identifying the Notes Content Provider and its authority
- Reviewing the provider's query, insert, update, and delete methods
- Building and running a separate Android test client
- Recording the observed results
- Identifying potential access-control concerns
- Documenting remediation recommendations

### Out of scope

- Testing applications without authorization
- Testing production applications or third-party services
- Claiming coverage of every Android component
- Claiming automated APK scanning
- Claiming that all possible provider access paths were tested

## 3. Target Details

| Property | Value |
|---|---|
| Application | DIVA Android training application |
| Provider class | `jakhar.aseem.diva.NotesProvider` |
| Provider authority | `jakhar.aseem.diva.provider.notesprovider` |
| Test client package | `com.droidshield.providercheck` |
| Main component | Notes Content Provider |

## 4. Tools and Techniques

The lab used the following tools and techniques:

- Android manifest inspection
- APK decoding and source-level review
- Java-based Android test client
- Android `ContentResolver`
- Provider query and CRUD operations
- Git for version control

Exact tool versions and device details should be added when recorded.

## 5. Test Procedure

### Step 1 — Inspect the manifest

The target application's manifest was reviewed to identify the provider
declaration, authority, enabled status, exported status, and any declared
read or write permissions.

### Step 2 — Review the provider implementation

The Notes Content Provider implementation was reviewed for its query,
insert, update, and delete methods.

The review looked for apparent access-control checks and examined how
database operations were performed.

### Step 3 — Prepare the test client

A separate Android test client was created with package name
`com.droidshield.providercheck`.

The client used Android's `ContentResolver` to communicate with the provider
in the authorized lab environment.

### Step 4 — Perform provider operations

The lab included query and CRUD tests.

The insert/update/delete test created a test note, updated its value, and
deleted the inserted record.

### Step 5 — Record observations

The visible results from the test runs were recorded.

| Operation | Recorded result |
|---|---|
| Query | 6 rows returned |
| Insert | A test note was inserted and a content URI was returned |
| Update | 1 row updated |
| Delete | 1 row deleted |

These are the results from the recorded lab runs, not a guarantee that every
possible request or configuration was tested.

### Step 6 — Review security implications

The provider was declared exported in the reviewed manifest. The provider
methods reviewed during this lab did not show apparent permission-enforcement
checks.

This may create an access-control concern if a production application exposes
sensitive data or operations through a similarly configured provider.

The practical impact depends on the data exposed, provider implementation,
caller permissions, and other application controls.

## 6. Limitations

- Testing was limited to the described DIVA training target.
- The recorded query result represents one test run.
- The reviewed methods and manifest do not establish that every possible
  access path was examined.
- The project currently demonstrates focused manual testing.
- DroidShield is not currently a general-purpose automated APK scanner.
- Remediation has not been validated as part of the recorded results.

## 7. Recommended Follow-up Tests

- Test provider access from a separate application.
- Verify whether access is denied when suitable permissions are absent.
- Review access to individual records and query results.
- Apply a remediation in a controlled test copy.
- Repeat the tests after remediation.
- Record evidence for both allowed and denied access.

## 8. Responsible Testing

All testing should be performed only on applications and devices owned by
the tester or where explicit authorization has been granted.

DIVA is intentionally vulnerable and is used as a training target.
