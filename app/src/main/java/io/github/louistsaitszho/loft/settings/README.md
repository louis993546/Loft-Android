# Settings

## WTF is there an activity here?

I want to use `PreferenceFragmentCompat` inside the `MainFragment`'s `ViewPager`, but I don't think
adding another layer of navigation arch is a good idea, nor do I want to go back to manage fragment
stack. In this case, having an `Activity` that act as a container seems like the most logical
solution:

- `PreferenceFragmentCompat` ✅ 
- From UX perspective, settings are usually more isolated to avoid accidental triggers (I think)
- Having to deal with swipe tap in `SettingsFragment` or `MoreFragment` sounds pretty painful