# Tywragriculture
A mod aimed to build onto Minecraft's farming and food gathering vibe, adding new crops, dishes, drinks and so much more to see! (and eat :D)

---
### So, just for good measure, and in fashion of our mods, let's list some core features in this mod (in no particular order):
- New Foods, Dishes, Drinks, and many more types of consumables!
- New Crops.
- A very small API.
- Extra utensil blocks like the Crate and the Sink!
- The `/agriculture` command, which displays some minimal info of your current setting!
  - `/agriculture dump_config` shows ALL the Config settings you currently have!
  - `/agriculture reload` reloads all the Config settings that don't need an entire re-run of Minecraft.
- A more robust way of handling logging, falling in line with options in Config. Such as Debug mode and Suppress Warns!
---
### A very simple Config System is also included!:
```json5
{ 
  /* Psst, this is a README Comment!*/
  /* All the values in here are the default values.*/
  // DO NOT TOUCH THIS. IT IS IMPORTANT INTERNAL STUFF.
  "format_version": "1.0",
  // Several configurations for in-world features.
  "world_config": {
    // Whether to allow right-clicking to harvest crops.
    "right_click_harvest": true
  },
  // Several configurations for utility features.
  "util_config": {
    // Whether to display debug information in the console.
    "debug_mode": false,
    // Whether to suppress all warnings from this mod. NOT RECOMMENDED.
    "suppress_warns": false
  }
}
```
> [!NOTE]
> This file can be found at `.../config/tywragriculture.json5`.  
> The Config Handling is done by an API mod made by us called BlossomBridge. 
> Any failure of the system [should be reported over there](https://github.com/Tywrap-Studios/BlossomBridge/issues) and preferably not here.
---
### Extra info:
> [!NOTE]
> This mod could maybe be addressed as "very similar to Farmer's Delight". And I am aware of that. Though note it is NOT an exact copy.  
> We aim to add extra, original, features that are not present in FD.  
> Some type of Compat with FD is planned though, so look forward to that I guess.