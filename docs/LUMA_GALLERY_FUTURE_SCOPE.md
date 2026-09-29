# Luma Gallery — Future Scope

## Overview

Luma Gallery is a separate Android gallery application project built with
Kotlin and Jetpack Compose. It is a potential future application-security
testing target and is not currently part of the DroidShield implementation.

## Planned Security Review

The following areas may be reviewed in a future authorized test cycle:

- Media access and permission handling.
- User-selected media access and access revocation.
- Exported activities, services, receivers, and content providers.
- Application data storage and exposure.
- Explicit media-transfer behavior and user consent.
- USB debugging and wireless debugging considerations.

## Planned Testing Approach

Testing should use an authorized build, test devices or emulators, and
synthetic media where practical. Findings should include the test setup,
steps to reproduce, observed behavior, impact, and remediation guidance.

No vulnerability or test result is claimed in this document. Each item
must be assessed and documented only after testing is performed.

## Relationship to DroidShield

DroidShield currently documents focused Android security testing using the
DIVA training application and its notes content provider. Luma Gallery is
a separate future project and should not be described as an implemented
DroidShield feature.

## Future Deliverables

- Review the Luma Gallery source and application configuration.
- Define an authorized test plan.
- Execute and record the planned tests.
- Document confirmed observations and remediation recommendations.
- Update this document to distinguish completed work from remaining work.
