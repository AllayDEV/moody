# Moody

An emoticon plugin that shows the mood of the players

> **This plugin is primarily intended for lobby/hub servers.**  
> _Moody respects the player helmet item, but should only be used on lobby/hub servers_

### How does this work?

To use the plugin, enter a symbol in Chat that was defined in the config.  
You can try out the one following symbols:  
`:)` `:D` `xD` `:O` `<3` `:*`

### Configuration

In the configuration file (`./plugins/Moody/config.json`) you will find some things to configure.  
```json5
{
  // Deactivate the identification of emoticons globally
  "enabled": true,
  // The time how long the emoticon stays on the player head (1 second)
  "delay": {
    "time": 1,
    // Available units: NANOSECONDS, MICROSECONDS, MILLISECONDS, SECONDS, MINUTES, HOURS, DAYS
    "unit": "SECONDS"
  },
  // You can add, edit or remove types
  "types": [
    ...
  ]
}
```