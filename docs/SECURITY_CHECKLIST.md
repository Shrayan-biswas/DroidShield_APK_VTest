# Android Security Testing Checklist

Use this checklist only for applications and devices you are authorized to test.

## Test Details
- Date:
- Tester: Shrayan Biswas
- Target application:
- App version / APK hash:
- Device or emulator:
- Android version:

## Manifest Review
- [ ] Identify exported activities
- [ ] Identify exported services
- [ ] Identify exported broadcast receivers
- [ ] Identify exported content providers
- [ ] Review declared permissions
- [ ] Review backup configuration
- [ ] Record findings and evidence

## Content Provider Testing
- [ ] Identify provider authority and export status
- [ ] Check provider read/write permissions
- [ ] Test query behavior
- [ ] Test insert behavior
- [ ] Test update behavior
- [ ] Test delete behavior
- [ ] Check whether unauthorized access is rejected
- [ ] Confirm test data cleanup

## Evidence
- [ ] Record exact steps
- [ ] Capture relevant screenshots or logs
- [ ] Record expected and actual results
- [ ] Avoid including passwords, tokens, or personal data

## Reporting
- [ ] Assign a finding ID
- [ ] Describe the security impact
- [ ] Include reproducible evidence
- [ ] Recommend a mitigation
- [ ] State testing limitations
- [ ] Re-test after remediation

## Final Review
- [ ] Confirm testing stayed within scope
- [ ] Remove temporary test data
- [ ] Review files before committing
