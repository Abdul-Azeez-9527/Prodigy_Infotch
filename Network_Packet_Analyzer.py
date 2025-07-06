from scapy.all import sniff, IP, TCP, UDP, ICMP

def show_packet(pkt):
    if IP in pkt:
        print("\n[+] Packet Captured")
        print(f"Source IP      : {pkt[IP].src}")
        print(f"Destination IP : {pkt[IP].dst}")
        print(f"Packet Length  : {len(pkt)} bytes")

        if TCP in pkt:
            print("Protocol       : TCP")
            print(f"Ports          : {pkt[TCP].sport} -> {pkt[TCP].dport}")
        elif UDP in pkt:
            print("Protocol       : UDP")
            print(f"Ports          : {pkt[UDP].sport} -> {pkt[UDP].dport}")
        elif ICMP in pkt:
            print("Protocol       : ICMP")
        else:
            print(f"Protocol       : Other ({pkt[IP].proto})")

print("Sniffing... Press Ctrl+C to stop.")
sniff(filter="ip", prn=show_packet, count=5)
