# Week 12 Reflection — Bonus Feature Sprint (Week 2 of 2, Final)

*Second and last week of bonus feature work. Week 13 has no build time — this is the last chance to get your feature demo-ready before Week 14. This template replaces the standard weekly reflection, same as last week.*

**Name:** Danny King
**Date:** 08/06/2026
**My assigned bonus feature:** Quotes

---

## Commits This Week

**Link:** https://github.com/DannyKin/media-tracker-android/pull/11

---

## Code Review

**Reviewed:** Hunter Bammert-Mueller
**Link to my review:** https://github.com/Hunterbounty11/media-tracker-android/pull/11

### What I Looked At

I focused on his Priority files. I was trying to see if there was any mistake on the files.

### What I Noticed

I noticed an error on his Priority screen. He had change.consume() but I didn't see an import androidx.compose.ui.input.pointer.consume . It matters that's an error in the file which need to be fixed before the program can run.

### Comments I Left

I talked about the error I saw on his Priority screen and how his priorityviewmodel looks very good.

---

## Bonus Feature — Final Status

<!-- Be concrete and honest. This is your last chance to flag something before demos.
     What does your feature actually do, end to end, right now? What's polished vs. rough?
     Is there anything you know is broken or half-done that you want on my radar before Week 14? -->

**What works end-to-end, right now:** A majority of the project works, but I would say I'm struggling with the unlikeQuote.

**Tests written for this feature:** 

**Known gaps or rough edges going into demos:** I would say there are features on my view model that aren't working the way that I want it to.

---

## One Thing I Understood More Deeply

After working on the quote features, I realized that the repository is mainly responsible for getting and changing data from the API, while the ViewModel keeps track of the app's state and updates the UI.

---

## One Thing I'm Still Confused About

I was confused about why I needed both of the repository and ViewModel because they seemed like they were doing the same thing.

---

## Anything Else *(optional)*

---

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Honest final-status report — what works end-to-end, what's rough, what's tested — plus a specific, genuine "Understood More Deeply" that reflects on the sprint as a whole, not just this week. | Present but vague, or only reports on this week rather than the feature's overall state. | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** same as every other week — I check the link before grading.
