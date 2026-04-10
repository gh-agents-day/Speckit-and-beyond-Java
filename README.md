# Agent-Driven Spec Development: The TaskManager Feature Sprint

> **Product Demand:** Extend a working task manager with priority support, search, and advanced filtering — all driven by GitHub agents.

## The Scenario

**Monday, 9:00 AM.** The TaskManager app is live, but the team is swamped with feature requests.

Users need to **prioritize tasks**, **search by keyword**, and **filter by status, priority, and category** — or they're switching to a competitor.

Engineering Lead says: deliver all three features by end of sprint, with clean specs and no regressions.

This workshop walks you through exactly that — using GitHub's agent ecosystem to go from a bare-bones CRUD app to a fully-featured, production-ready task manager.

---

## What You'll Learn

| Tool             | What You Do                                                                     |
| ---------------- | ------------------------------------------------------------------------------- |
| **Spec Kit**     | Drive governance, planning, and code generation from a specification            |
| **Custom Agent** | Create and configure your own agent to automate specialized workflows and tasks |

---

## Prerequisites

- **Java 17+** installed
- **Maven 3.8+** installed
- **Valid GitHub Copilot subscription** (Individual, Business, or Enterprise)
- [VS Code](https://code.visualstudio.com/download) with GitHub Copilot Chat extension
- [Git CLI](https://git-scm.com/install/) for version control
- [Speckit](https://github.com/github/spec-kit?tab=readme-ov-file#-get-started) installed and configured
- [UV](https://docs.astral.sh/uv/getting-started/installation/) (for installing Spec Kit)

> **Starter Code Provided:** TaskManager Spring Boot brownfield application — a working but feature-incomplete task management system ready for your enhancements

---

## Workshop Structure

| Step | Exercise                             | Topic                                | Time        |
| ---- | ------------------------------------ | ------------------------------------ | ----------- |
| 1    | [Exercise 1](workshop/exercise-1.md) | Analyse the Codebase & Identify Gaps | ~3 min      |
| 2    | [Exercise 2](workshop/exercise-2.md) | Spec Kit Setup                       | ~5 min      |
| 3    | [Exercise 3](workshop/exercise-3.md) | Constitution & Specification         | ~8 min      |
| 4    | [Exercise 4](workshop/exercise-4.md) | Plan & Tasks                         | ~7 min      |
| 5    | [Exercise 5](workshop/exercise-5.md) | Implement All Three Features         | ~10 min     |
| —    | **Total**                            |                                      | **~33 min** |

---

## Features You'll Build

| Feature              | Description                                                          |
| -------------------- | -------------------------------------------------------------------- |
| **Priority Support** | Add `HIGH`, `MEDIUM`, `LOW` priority to tasks with full CRUD support |
| **Search Bar**       | Keyword search across title, description, category, and assignee     |
| **Status Filter**    | Filter the task table by `TODO`, `IN_PROGRESS`, `DONE`, `CANCELLED`  |
| **Priority Filter**  | Filter tasks by priority level                                       |
| **Category Filter**  | Filter tasks by category                                             |

---

> The workshop has been tested with the following AI models on GitHub Copilot: `Claude Sonnet 4.6`, `GPT-4.1`. Results may vary with different models. If you encounter issues, try switching to one of these models in your Copilot settings.

---

## Get Started

[![Use this Template](https://img.shields.io/badge/Use%20this%20Template-%E2%86%92-1f883d?style=for-the-badge&logo=github&labelColor=197935)](https://github.com/new?template_owner=CanarysAutomations&template_name=Draft-Speckit-On-Java&owner=%40me&name=Draft-Speckit-On-Java&description=Agent-Driven+Spec+Development:+TaskManager+Feature+Sprint&visibility=public)

Once your repo is created and cloned, run the app first:

```bash
mvn spring-boot:run
```

Then open [http://localhost:8080](http://localhost:8080) to see the current state of the application, and start here: [Exercise 1 — Analyse the Codebase](workshop/exercise-1.md)

## Resources

- [Spec Kit Documentation](https://github.github.io/spec-kit/)
- [GitHub Repository](https://github.com/github/spec-kit)
- [Video Overview](https://www.youtube.com/watch?v=a9eR1xsfvHg)
