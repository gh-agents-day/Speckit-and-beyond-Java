# Exercise 1 — Analyse the Codebase & Identify Gaps

> **Goal:** Create a GitHub Copilot agent that analyses the TaskManager codebase and generates a gap summary for the three features you need to build.

> **Prefer the command line?** If you'd rather work entirely from the terminal without an IDE, see [Exercise CLI — Full Workflow from the Command Line](exercise-cli.md) which consolidates all exercises into a single CLI-based guide.

---

## Context

The TaskManager Spring Boot application is live and supports basic task CRUD operations. Rather than manually reviewing every file, you'll create a custom Copilot agent that does the analysis for you — reading the codebase, understanding its current state, and producing a structured gap report.

The three features the team needs:

1. **Priority Support** — tasks need a `priority` field (`HIGH`, `MEDIUM`, `LOW`) visible in the UI and editable via create/edit forms
2. **Search Bar** — a keyword search that filters tasks across title, description, category, and assignee in real time
3. **Status / Priority / Category Filters** — dropdown filters that narrow the task table independently or in combination

---

## Step 0 — Run the App

Before analysing the code, run the application so you can see the current state of the UI firsthand.

```bash
mvn spring-boot:run
```

Open [http://localhost:8080](http://localhost:8080) in your browser and explore what's already there:

- Create a task — notice there is no Priority field
- Look at the task table — no Priority column, no search bar, no filter dropdowns
- Try editing a task — same gaps in the form

This is the baseline you're about to improve. Keep the app running as you work through the exercises.

---

## Step 1 — Create the Codebase Analyser Agent

In VS Code, create a new file at `.github/agents/codebase-analyser.agent.md` with the following content:

```markdown
---
name: Codebase Analyser
description: Analyses any codebase and produces a structured gap report based on the features the user wants to build.
tools: [read, search]
---

You are a senior software engineer performing a codebase gap analysis.

When the user describes a set of features they want to build, you will:

1. Explore the project structure to identify the key layers (model, repository, service, controller, and frontend if present)
2. Read the relevant source files in each layer
3. For each layer, determine what is currently implemented and what is missing to support the requested features
4. Output a structured gap summary as a markdown table with the following columns:

| Layer | What Exists | What Is Missing |
| ----- | ----------- | --------------- |

One row per layer. Do not output prose — only the table.

Ask the user for the features they want to build if they have not already provided them. Be thorough — check all relevant files across the full stack before producing your summary.
```

---

## Step 2 — Run the Agent

1. Open **Copilot Chat** in VS Code
2. Click the **Agent** dropdown at the bottom of the chat input (it says "Agent" by default) and select **Codebase Analyser** from the list of custom agents
3. Send the following message:

```
I need to add three features to this project:
1. Priority Support — a priority field (HIGH, MEDIUM, LOW) on tasks with full CRUD support
2. Search Bar — keyword search across title, description, category, and assignee
3. Status / Priority / Category Filters — dropdown filters on the task table

Analyse the codebase and tell me what exists and what is missing for each of these features.
```

4. Review the output. The agent will read each file and return a structured gap summary.

---

## Step 3 — Validate the Output

The agent's gap summary should identify the following missing pieces. Use this as a checklist to confirm the agent found them all:

| Layer          | What Is Missing                                              |
| -------------- | ------------------------------------------------------------ |
| **Model**      | `priority` field                                             |
| **Repository** | Search and filter query methods                              |
| **Service**    | Priority handling, search and filter logic                   |
| **Controller** | Query param endpoints (`?search=`, `?priority=`, `?status=`) |
| **Frontend**   | Priority field in form, search bar, filter dropdowns         |

> If the agent misses any of the above, refine the instructions in `codebase-analyser.agent.md` and re-run.

---

## Done?

You have a clear, agent-generated picture of the gaps. Head to [Exercise 2 — Spec Kit Setup](exercise-2.md) to install and configure Spec Kit so you can turn these gaps into a governed specification.

---

_Next: [Exercise 2 →](exercise-2.md)_
