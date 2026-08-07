# Week {{N}} Reflection

**Name:** Danny King
**Date:** 08/06/2026

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

## One Thing I Understood More Deeply

After working on the quote features, I realized that the repository is mainly responsible for getting and changing data from the API, while the ViewModel keeps track of the app's state and updates the UI.

## One Thing I'm Still Confused About

I was confused about why I needed both of the repository and ViewModel because they seemed like they were doing the same thing.

## Anything Else *(optional)*

## Rubric

*You don't need to self-assess — this is here so you know what I'm looking at.*

| Section | Points | Full Credit | Half Credit | No Credit |
|:---|:---:|:---|:---|:---|
| **Reflection** | 10 | Specific, honest responses to "More Deeply" and "Still Confused" sections. Shows genuine thinking — not just "I learned X." | Responses are present but vague or generic ("I got better at Compose"). | Missing or one-word answers. |
| **Code Review** | 10 | Specific observation about the code with explanation of why it matters (or a substantive positive comment). Link to review present and verified. | A question or comment that shows you read the code, but lacks explanation. | "Looks good!" or equivalent. Missing link. Review not found on GitHub. |
| **Total** | **20** | | | |

**A note on the code review score:** I check that the review actually exists on GitHub before grading. The written summary here and the GitHub comment should match. If the review isn't there, the written summary can't earn credit.
