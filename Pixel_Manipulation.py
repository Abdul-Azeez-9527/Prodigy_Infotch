from PIL import Image
def encrypt_image(image_path, key, output_path):
    try:
        img = Image.open(image_path).convert("RGB")  # Ensure RGB
        pixels = img.load()

        width, height = img.size
        for x in range(width):
            for y in range(height):
                r, g, b = pixels[x, y]
                pixels[x, y] = (r ^ key, g ^ key, b ^ key)
        img.save(output_path)
        print(f"[+] Image encrypted and saved as '{output_path}'")
    except Exception as e:
        print("Error:", e)
def decrypt_image(image_path, key, output_path):
    encrypt_image(image_path, key, output_path)
if __name__ == "__main__":
    print("Image Encryption/Decryption Tool")
    print("1. Encrypt")
    print("2. Decrypt")
    choice = input("Choose (1/2): ")

    img_path = input("Enter image path: ")
    key = int(input("Enter key (0-255): "))

    if choice == '1':
        output = input("Enter output path for encrypted image: ")
        encrypt_image(img_path, key, output)
    elif choice == '2':
        output = input("Enter output path for decrypted image: ")
        decrypt_image(img_path, key, output)
    else:
        print("Invalid choice.")
