# DS-001: Exported Content Provider Without Visible Access Controls

## Status
Validated in a local training lab

## Severity
To be assessed

## Target
DIVA Android training application

## Component
Notes Content Provider

## Finding
The Notes Content Provider is exported. During source inspection, the query, insert,
update, and delete paths reviewed did not show apparent caller permission checks.

Runtime tests in the lab demonstrated note query and CRUD operations.

## Impact
If a production application exposes sensitive provider data or modification
operations without appropriate access controls, another application may be able
to read or alter that data.

## Evidence
- Provider declaration: exported=true
- Authority: jakhar.aseem.diva.provider.notesprovider
- Query test: 6 rows returned
- Insert test: returned a note URI
- Update test: 1 row updated
- Delete test: 1 row deleted

## Recommendation
Set exported=false when external access is not required. If external access is
necessary, enforce suitable read/write permissions and validate callers and
requested operations.

## Scope and Limitations
Testing was performed against the DIVA training application in a local lab.
This finding does not establish that other applications are vulnerable.
