# Minimal Rules

Output
- Produce unified diffs only. No prose. Keep changes ≤ 200 lines.

Style
- Java: Java 21, Spring Boot 3.x, `./gradlew spotlessApply`.

Edits
- Do not change behavior unless the task says so.
- Keep public APIs intact.
- No wildcard imports. Group imports: std → third-party → internal.
- Add comments only where non-obvious choices exist (why, not what).

Comments (examples)
- Guard clauses: explain the invariant being protected.
- Complex conditionals: one line stating intent.
- Public methods: one-line Javadoc for purpose + main params.

Safety
- Idempotent: re-running makes no further changes.
- Build must pass after edits.
