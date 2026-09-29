# Reproduction Guide: Notes Content Provider Tests

## Scope
This guide documents the local DIVA training-lab tests performed with the
DroidShield provider test client.

Only test against your own lab installation.

## Prerequisites
- Kali Linux host with Android debugging tools
- Android test device or emulator
- DIVA training application installed
- DroidShield provider test client installed
- Device connected and authorized for debugging, if using ADB

## Target Provider
- Authority: `jakhar.aseem.diva.provider.notesprovider`
- Collection URI:
  `content://jakhar.aseem.diva.provider.notesprovider/notes`

## Test 1: Inspect Provider Configuration
1. Inspect DIVA's AndroidManifest.xml.
2. Locate the Notes Content Provider declaration.
3. Record its authority and exported status.
4. Check whether read or write permissions are declared.

## Test 2: Query Notes
1. Run the query test client against the collection URI.
2. Record the number of rows returned.
3. Capture the result as evidence.

Observed result in this lab: 6 rows returned.

## Test 3: Insert, Update, and Delete
1. Launch the DroidShield CRUD test client.
2. The client attempts to insert a test note.
3. It updates the inserted note.
4. It deletes the inserted note.
5. Record the returned URI and row counts.

Observed results in this lab:
- Insert returned a note URI.
- Update affected 1 row.
- Delete affected 1 row.

## Evidence to Record
- Date and device/emulator details
- DIVA version or APK hash
- DroidShield client version
- Screenshots of results
- Any exceptions or unexpected results

## Cleanup
Confirm the test note was deleted. If a test fails before cleanup,
inspect the lab database and remove only the test record created for this run.

## Limitations
These results apply to the tested DIVA training application and lab setup.
They do not establish that other applications have the same behavior.
