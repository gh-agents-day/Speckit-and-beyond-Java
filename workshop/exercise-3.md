# Exercise 3: Spec Kit — Constitution & Specification

> **Time:** ~8 minutes
> **Prerequisite:** Spec Kit installed and initialized ([Exercise 2](exercise-2.md))
> **Track:** Required for Exercises 4 and 5

---

> **Note for participants:** This exercise builds on Exercise 2 and is required before you can do Exercises 4 and 5. The outputs (`constitution.md` and `specification.md`) are referenced in the planning and implementation steps.

> **Prefer the command line?** If you'd rather work entirely from the terminal without an IDE, see [Exercise CLI — Full Workflow from the Command Line](exercise-cli.md) which consolidates all exercises into a single CLI-based guide.

---

## Goal

Define the governing principles for the feature sprint (constitution), then generate a detailed specification of what will be built across the full stack.

---

## Context

The TaskManager app needs three new features added across all layers:

| Feature                                  | Scope                                                      |
| ---------------------------------------- | ---------------------------------------------------------- |
| **Priority Support**                     | `Task` model, repository, service, controller, and UI form |
| **Search Bar**                           | Backend keyword search + frontend real-time filter         |
| **Status / Priority / Category Filters** | Backend query params + frontend dropdown controls          |

---

## Steps

**1.** Open Copilot Chat and run:

```
/speckit.constitution

Generate a constitution that captures the governing standards and principles for
this application — not for any specific feature, but as the lasting rules that
all future development must follow. Cover:

1. Architecture — layered structure (model → repository → service → controller → UI);
   each layer has a single responsibility and must not bypass the one above it
2. Data Storage — `data/tasks.json` is the single source of truth; all reads and
   writes go through `TaskRepository`; no layer may access the file directly
3. Field Naming — field names in the `Task` model, the JSON store, the REST API
   response, and the UI must be identical; no aliasing or renaming between layers
4. Validation — all input validation and business rule enforcement happens in
   `TaskService`; `TaskController` does not validate; `TaskRepository` does not validate
5. Frontend Standards — the UI is a single-page vanilla JS app; data is fetched
   from the backend on each operation; only edit state (`editingId`) is held in memory;
   the page does not reload to reflect data changes
6. Code Quality — no business logic in the controller; no file I/O outside the
   repository; no inline styles or scripts added to `index.html` outside its existing structure
```

> Spec Kit creates `.specify/constitution.md`.

---

**2.** Review `constitution.md`. It should define clear principles that every implementation decision in Exercises 4 and 5 must follow.

---

**3.** In Copilot Chat, run:

```
/speckit.specify

Extend the TaskManager Spring Boot app following the constitution:

1. Priority Support
   - Add a `priority` field (HIGH, MEDIUM, LOW) to the Task model
   - Persist and return priority in all CRUD operations
   - Show priority as a dropdown field in the create and edit form
   - Display the priority value as a column in the task table

2. Search Bar
   - Add keyword search support to the service layer with an optional `search` parameter
   - Search across title, description, category, and assignedTo fields (case-insensitive)
   - Frontend: a search input above the task table that filters results in real time

3. Status / Priority / Category Filters
   - Add filter support to the service layer with optional `status`, `priority`, and `category` parameters
   - Filters can be combined with each other and with search
   - Frontend: three dropdown controls above the task table

UI layout: the search bar and all three filter dropdowns (Status, Priority, Category)
must appear on a single row above the task table.
```

> Spec Kit creates `.specify/specification.md`.

---

**4.** Review `specification.md`. It defines **what** will be built — fields, backend methods, UI components, and success criteria.

---

> **Optional:** Before moving to Exercise 4, you can run `/speckit.clarify` to let Spec Kit identify any underspecified or ambiguous areas in your specification. This is useful if you want to tighten the spec before planning begins.
>
> ```
> /speckit.clarify
> ```
>
> Spec Kit will ask questions about anything unclear — for example, whether the priority field should have a default value, or how the search and filters should behave when combined. Answer them to refine `specification.md` before proceeding.

---

## Expected Output

`constitution.md` should capture the application's governing principles — architecture boundaries, data access rules, validation ownership, and frontend standards. Expect 5–7 principles, each clearly stating what is required and why.

`specification.md` should describe each feature in terms of what changes at each layer — model fields, backend methods, and UI components — along with success criteria that can be verified without running implementation code.

> Your output will vary based on how Spec Kit interprets your inputs. That's expected — focus on whether the principles are enforceable and the success criteria are measurable.

---

## What You Did

| Item              | Description                                                                                   |
| ----------------- | --------------------------------------------------------------------------------------------- |
| **Constitution**  | Defined the core principles guiding the feature implementation.                               |
| **Specification** | Created a detailed spec outlining the fields, endpoints, UI components, and success criteria. |

---

_Next: [Exercise 4 →](exercise-4.md)_
