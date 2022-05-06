
public class hill_cipher {
    // Java code to implement Hill Cipher
// Following function generates the
// key matrix for the key string
public int[][] getKeyMatrix(String key, int keyMatrix[][])
{
	int k = 0;
	for (int i = 0; i < 2; i++)
	{
		for (int j = 0; j < 2; j++)
		{
                    if(Character.isUpperCase(key.charAt(k))){
                        keyMatrix[i][j] = (key.charAt(k)) % 65;
                    }
                    else{
                        keyMatrix[i][j] = (key.charAt(k)) % 97;
                    }
                    k++;
		}
	}
        return keyMatrix;
}

// Following function encrypts the message
public void encrypt(int cipherMatrix[][],int keyMatrix[][],int messageVector[][], int n)
{
	int x, i, j;
	for (i = 0; i < n; i++)
	{
		for (j = 0; j < 2; j++)
		{
			cipherMatrix[i][j] = 0;
		
			for (x = 0; x < 2; x++)
			{
				cipherMatrix[i][j] +=
					keyMatrix[x][j] * messageVector[i][x];
			}
		
			cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
		}
	}
}


public String HillCipher(String message, int keyMatrix[][], int n)
{
	int [][]messageVector = new int[n][2];
         
        int k = 0;
	for (int i = 0; i < n; i++)
            for(int j = 0; j < 2; j++){
                if(Character.isUpperCase(message.charAt(k))){
                    messageVector[i][j] = (message.charAt(k)) % 65;
                }
                else{
                    messageVector[i][j] = (message.charAt(k)) % 97;
                }
                if(k == message.length() - 1)
                    break;
                else k++;
            }

	int [][]cipherMatrix = new int[n][2];
	encrypt(cipherMatrix, keyMatrix, messageVector, n);

	String CipherText="";

        int c = 0;
	for (int i = 0; i < n; i++)
            for(int j = 0; j < 2; j++){
                if(Character.isUpperCase(message.charAt(c++))){
                    CipherText += (char)(cipherMatrix[i][j] + 65);
                }
                else{
                    CipherText += (char)(cipherMatrix[i][j] + 97);
                }
            }
	return CipherText;
}
public String de_HillCipher(String message, String key, int n)
{       
    hill_cipher hill = new hill_cipher();
	// Get key matrix from the key string
	int [][]keyMatrix = new int[2][2];
	getKeyMatrix(key, keyMatrix);
        //tinh det() cua ma tran
        int a = keyMatrix[0][0]*keyMatrix[1][1];
        int b = keyMatrix[0][1]*keyMatrix[1][0];
        int e = (a - b)%26;
        int e_inv = hill.checkInv(e);
        //dao khoa K
        int x;
        x = keyMatrix[0][0];
        keyMatrix[0][0] = keyMatrix[1][1];
        keyMatrix[1][1] = x;
        keyMatrix[0][1] = keyMatrix[0][1]*(-1) + 26;
        keyMatrix[1][0] = keyMatrix[1][0]*(-1) + 26;
        
        
        for(int i = 0; i < 2; i++)
            for(int j = 0; j < 2; j++){
                if(keyMatrix[i][j]*e_inv > 26){
                    keyMatrix[i][j]= (keyMatrix[i][j]*e_inv)%26;
                }else keyMatrix[i][j]= keyMatrix[i][j]*e_inv;
            }
	int [][]cipherMatrix = new int[n][2];
         
        int k = 0;
	// Generate vector for the message
	for (int i = 0; i < n; i++)
            for(int j = 0; j < 2; j++){
                if(Character.isUpperCase(message.charAt(k))){
                    cipherMatrix[i][j] = (message.charAt(k)) % 65;
                }
                else{
                    cipherMatrix[i][j] = (message.charAt(k)) % 97;
                }
                if(k == message.length() - 1)
                    break;
                else k++;
           }

	int [][]messageVector = new int[n][2];

	// Following function generates
	// the encrypted vector
	encrypt(messageVector, keyMatrix, cipherMatrix, n);

	String Text="";

	// Generate the encrypted text from
	// the encrypted vector
        int c = 0;
	for (int i = 0; i < n; i++)
            for(int j = 0; j < 2; j++){
                if(Character.isUpperCase(message.charAt(c++))){
                    Text += (char)(messageVector[i][j] + 65);
                }
                else{
                    Text += (char)(messageVector[i][j] + 97);
                }
            }
	// Finally print the ciphertext
	return Text;
}
public int checkInv(int a){
    int flag = 0;
    int a_inv = -1;
    for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;
            if (flag == 1)
            {
                a_inv = i;
            }
        }
    return a_inv;
}


// Driver code
public static void main(String[] args)
{
	// Get the message to be encrypted
	String message = "HELP";
        int n = message.length()/2;
        if(message.length()%2 > 0)
            n += 1;

	// Get the key
        String key = "DDCF";
        hill_cipher h = new hill_cipher();
        System.out.print(h.de_HillCipher(message, key, n));
        
	
        

	
	}
}


